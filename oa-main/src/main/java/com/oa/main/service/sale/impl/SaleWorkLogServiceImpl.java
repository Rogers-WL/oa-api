package com.oa.main.service.sale.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.common.config.response.R;
import com.oa.common.utils.SecurityUtils;
import com.oa.framework.web.enums.BusinessExceptionEnum;
import com.oa.framework.web.exception.BusinessException;
import com.oa.framework.web.service.PermissionService;
import com.oa.main.doman.sale.SaleWorkLogDo;
import com.oa.main.dto.sale.SaleWorkLogDto;
import com.oa.main.mapper.sale.SaleWorkLogMapper;
import com.oa.main.service.sale.ISaleWorkLogService;
import com.oa.main.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 【请填写功能名称】 Service业务层处理
 *
 * @author rogers
 * @date 2021-09-26
 */
@Service
public class SaleWorkLogServiceImpl extends ServiceImpl<SaleWorkLogMapper, SaleWorkLogDo> implements ISaleWorkLogService {

    @Autowired
    private SaleWorkLogMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R save(SaleWorkLogDto dto) {
        String id = dto.getId();
        SaleWorkLogDo saleWorkLogDo = new SaleWorkLogDo();
        BeanUtils.copyProperties(dto, saleWorkLogDo);
        if (id == null) {
            saleWorkLogDo.setId(CommonUtil.generateId());
            saleWorkLogDo.setStatus(2);
            CommonUtil.setCreateAndUpdateInfo(saleWorkLogDo, true);
            save(saleWorkLogDo);
        } else {
            SaleWorkLogDo old = getById(id);
            if (old == null) {
                throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
            }
            CommonUtil.setCreateAndUpdateInfo(saleWorkLogDo, false);
            updateById(saleWorkLogDo);
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
    public R recall(String id) {
        SaleWorkLogDo workLogDo = getById(id);
        if (workLogDo == null) {
            throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
        }
        updateById(new SaleWorkLogDo().setId(id).setStatus(1));
        return R.success();
    }

    @Override
    public R manager(SaleWorkLogDto dto) {
        SaleWorkLogDo workLogDo = getById(dto.getId());
        if (workLogDo == null) {
            throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
        }
        updateById(new SaleWorkLogDo().setId(dto.getId()).setManager(SecurityUtils.getUsername())
                .setManagerName(SecurityUtils.getUserShowName()).setManagerComment(dto.getManagerComment())
                .setManagerTime(LocalDateTime.now()).setStatus(3));
        return R.success();
    }

    @Override
    public R boss(SaleWorkLogDto dto) {
        SaleWorkLogDo workLogDo = getById(dto.getId());
        if (workLogDo == null) {
            throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
        }
        updateById(new SaleWorkLogDo().setId(dto.getId()).setBoss(SecurityUtils.getUsername())
                .setBossName(SecurityUtils.getUserShowName()).setBossComment(dto.getBossComment())
                .setBossTime(LocalDateTime.now()).setStatus(0));
        return R.success();
    }

}
