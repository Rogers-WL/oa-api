package com.oa.main.service.sale.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.common.config.response.R;
import com.oa.main.config.enums.BusinessExceptionEnum;
import com.oa.main.config.exception.BusinessException;
import com.oa.main.doman.sale.SaleWorkLeaveDo;
import com.oa.main.dto.sale.SaleWorkLeaveDto;
import com.oa.main.mapper.sale.SaleWorkLeaveMapper;
import com.oa.main.service.sale.ISaleWorkLeaveService;
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
public class SaleWorkLeaveServiceImpl extends ServiceImpl<SaleWorkLeaveMapper, SaleWorkLeaveDo> implements ISaleWorkLeaveService {

    @Autowired
    private SaleWorkLeaveMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R save(SaleWorkLeaveDto dto) {
        String id = dto.getId();
            SaleWorkLeaveDo saleWorkLeaveDo = new SaleWorkLeaveDo();
        BeanUtils.copyProperties(dto, saleWorkLeaveDo);
        if (id == null) {
                saleWorkLeaveDo.setId(CommonUtil.generateId());
            CommonUtil.setCreateAndUpdateInfo(saleWorkLeaveDo, true);
            save(saleWorkLeaveDo);
        } else {
                SaleWorkLeaveDo old = getById(id);
            if (old == null) {
                throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
            }
            updateById(saleWorkLeaveDo);
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
