package com.oa.main.service.sale.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.common.config.response.R;
import com.oa.framework.web.enums.BusinessExceptionEnum;
import com.oa.framework.web.exception.BusinessException;
import com.oa.main.doman.sale.SaleOrderDo;
import com.oa.main.dto.approve.CommonApproveDto;
import com.oa.main.dto.approve.CommonOrderDto;
import com.oa.main.dto.sale.SaleOrderDto;
import com.oa.main.mapper.sale.SaleOrderMapper;
import com.oa.main.service.sale.ISaleOrderService;
import com.oa.main.utils.CommonUtil;
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
public class SaleOrderServiceImpl extends ServiceImpl<SaleOrderMapper, SaleOrderDo> implements ISaleOrderService {

    @Autowired
    private SaleOrderMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R save(SaleOrderDto dto) {
        String id = dto.getId();
        SaleOrderDo saleOrderDo = new SaleOrderDo();
        if (id == null) {
            BeanUtils.copyProperties(dto, saleOrderDo);
            saleOrderDo.setId(CommonUtil.generateId());
            saleOrderDo.setValidMoney(dto.getOrderPrice());
            saleOrderDo.setStatus(3);
            CommonUtil.setCreateAndUpdateInfo(saleOrderDo, true);
            save(saleOrderDo);
        } else {
            SaleOrderDo old = getById(id);
            if (old == null) {
                throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
            }
            updateById(saleOrderDo);
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
    public R approve(CommonApproveDto approveDto) {
        String id = approveDto.getId();
        SaleOrderDo old = getById(id);
        if (old == null) {
            throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
        }
        if (approveDto.getIsAgree()) {

        }
        return null;
    }

    @Override
    public R operateOrder(CommonOrderDto dto) {
        return null;
    }
}
