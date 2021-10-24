package com.oa.main.service.sale.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.common.config.response.R;
import com.oa.framework.web.enums.BusinessExceptionEnum;
import com.oa.framework.web.exception.BusinessException;
import com.oa.main.doman.sale.SaleWechatDo;
import com.oa.main.dto.sale.SaleWechatDto;
import com.oa.main.mapper.sale.SaleWechatMapper;
import com.oa.main.service.sale.ISaleWechatService;
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
public class SaleWechatServiceImpl extends ServiceImpl<SaleWechatMapper, SaleWechatDo> implements ISaleWechatService {

    @Autowired
    private SaleWechatMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R save(SaleWechatDto dto) {
        String id = dto.getId();
        SaleWechatDo saleWechatDo = new SaleWechatDo();
        BeanUtils.copyProperties(dto, saleWechatDo);
        if (id == null) {
            saleWechatDo.setId(CommonUtil.generateId());
            saleWechatDo.setStatus(0);
            CommonUtil.setCreateAndUpdateInfo(saleWechatDo, true);
            save(saleWechatDo);
        } else {
            SaleWechatDo old = getById(id);
            if (old == null) {
                throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
            }
            CommonUtil.setCreateAndUpdateInfo(saleWechatDo, false);
            updateById(saleWechatDo);
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
