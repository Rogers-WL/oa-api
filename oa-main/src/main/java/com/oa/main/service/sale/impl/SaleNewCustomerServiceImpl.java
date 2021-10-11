package com.oa.main.service.sale.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.common.config.response.R;
import com.oa.common.utils.StringUtils;
import com.oa.framework.web.enums.BusinessExceptionEnum;
import com.oa.framework.web.exception.BusinessException;
import com.oa.main.doman.sale.SaleNewCustomerDo;
import com.oa.main.dto.sale.SaleNewCustomerDto;
import com.oa.main.mapper.sale.SaleNewCustomerMapper;
import com.oa.main.service.sale.ISaleNewCustomerService;
import com.oa.main.utils.CommonUtil;
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
public class SaleNewCustomerServiceImpl extends ServiceImpl<SaleNewCustomerMapper, SaleNewCustomerDo> implements ISaleNewCustomerService {

    @Autowired
    private SaleNewCustomerMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R save(SaleNewCustomerDto dto) {
        String id = dto.getId();
            SaleNewCustomerDo saleNewCustomerDo = new SaleNewCustomerDo();
        BeanUtils.copyProperties(dto, saleNewCustomerDo);
        if (id == null) {
                saleNewCustomerDo.setId(CommonUtil.generateId());
            CommonUtil.setCreateAndUpdateInfo(saleNewCustomerDo, true);
            save(saleNewCustomerDo);
        } else {
                SaleNewCustomerDo old = getById(id);
            if (old == null) {
                throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
            }
            updateById(saleNewCustomerDo);
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
}
