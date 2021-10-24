package com.oa.main.service.sale.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.common.config.response.R;
import com.oa.common.utils.SecurityUtils;
import com.oa.framework.web.enums.BusinessExceptionEnum;
import com.oa.framework.web.exception.BusinessException;
import com.oa.framework.web.service.PermissionService;
import com.oa.main.constant.CommonConstant;
import com.oa.main.doman.sale.SaleWorkLeaveDo;
import com.oa.main.dto.approve.CommonApproveDto;
import com.oa.main.dto.sale.SaleWorkLeaveDto;
import com.oa.main.mapper.sale.SaleWorkLeaveMapper;
import com.oa.main.service.sale.ISaleWorkLeaveService;
import com.oa.main.utils.CommonUtil;
import com.oa.main.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * 【请填写功能名称】 Service业务层处理
 *
 * @author rogers
 * @date 2021-09-26
 */
@Service
public class SaleWorkLeaveServiceImpl extends ServiceImpl<SaleWorkLeaveMapper, SaleWorkLeaveDo> implements ISaleWorkLeaveService {

    @Autowired
    private SaleWorkLeaveMapper mapper;
    @Autowired
    private PermissionService ss;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R save(SaleWorkLeaveDto dto) {
        String id = dto.getId();
        if (id == null) {
            SaleWorkLeaveDo saleWorkLeaveDo = new SaleWorkLeaveDo();
            BeanUtils.copyProperties(dto, saleWorkLeaveDo);
            saleWorkLeaveDo.setStartTime(DateUtil.stringToDatTime(dto.getStartTime()));
            saleWorkLeaveDo.setEndTime(DateUtil.stringToDatTime(dto.getEndTime()));
            saleWorkLeaveDo.setId(CommonUtil.generateId());
            CommonUtil.setCreateAndUpdateInfo(saleWorkLeaveDo, true);
            saleWorkLeaveDo.setStatus(3);
            // 主管请假
            if (ss.hasRole(CommonConstant.ROLE_MANAGER)) {
                saleWorkLeaveDo.setStatus(4);
            }
            save(saleWorkLeaveDo);
        } else {
            SaleWorkLeaveDo old = getById(id);
            if (old == null) {
                throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
            }
            updateById(new SaleWorkLeaveDo().setId(id).setStatus(2));
        }
        return R.success();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R del(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            removeByIds(Arrays.asList(ids.split(",")));
        }
        return R.success();
    }

    @Override
    public R approve(CommonApproveDto dto) {
        SaleWorkLeaveDo old = getById(dto.getId());
        SaleWorkLeaveDo workLeaveDo = new SaleWorkLeaveDo().setId(dto.getId());
        if (dto.getIsAgree()) {
            Integer status = old.getStatus();
            workLeaveDo.setStatus(status == 3 ? 4 : status == 4 ? 5 : status == 5 ? 6 : 0);
        } else {
            if (StringUtils.isBlank(dto.getReason())) {
                throw new BusinessException("审批不通过理由不能为空");
            }
            workLeaveDo.setStatus(1)
                    .setUnpassComment(dto.getReason())
                    .setHandler(SecurityUtils.getUsername())
                    .setHandlerName(SecurityUtils.getUserShowName());

        }
        CommonUtil.setCreateAndUpdateInfo(workLeaveDo, false);
        updateById(workLeaveDo);
        return null;
    }
}
