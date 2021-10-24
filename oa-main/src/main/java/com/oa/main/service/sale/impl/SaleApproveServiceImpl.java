package com.oa.main.service.sale.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.common.config.response.R;
import com.oa.common.utils.StringUtils;
import com.oa.framework.web.enums.BusinessExceptionEnum;
import com.oa.framework.web.exception.BusinessException;
import com.oa.main.doman.sale.SaleApproveDo;
import com.oa.main.doman.sale.SaleApproveDo;
import com.oa.main.dto.sale.SaleApproveDto;
import com.oa.main.dto.sale.SaleApproveDto;
import com.oa.main.mapper.sale.SaleApproveMapper;
import com.oa.main.mapper.sale.SaleApproveMapper;
import com.oa.main.service.sale.ISaleApproveService;
import com.oa.main.service.sale.ISaleApproveService;
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
public class SaleApproveServiceImpl extends ServiceImpl<SaleApproveMapper, SaleApproveDo> implements ISaleApproveService {

    @Autowired
    private SaleApproveMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R save(SaleApproveDto dto) {
        String id = dto.getId();
        SaleApproveDo saleApproveDo = new SaleApproveDo();
        BeanUtils.copyProperties(dto, saleApproveDo);
        if (id == null) {
            saleApproveDo.setId(CommonUtil.generateId());
            save(saleApproveDo);
        } else {
            SaleApproveDo old = getById(id);
            if (old == null) {
                throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
            }
            updateById(saleApproveDo);
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
