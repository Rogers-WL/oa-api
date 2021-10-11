package com.oa.main.service.sale;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.common.config.response.R;
import com.oa.main.doman.sale.SaleNewCustomerDo;
import com.oa.main.dto.sale.SaleNewCustomerDto;

/**
 * 【请填写功能名称】 Service接口
 *
 * @author rogers
 * @date 2021-09-26
 */
public interface ISaleNewCustomerService extends IService<SaleNewCustomerDo> {

    R save(SaleNewCustomerDto dto);

    R del(String ids);
}
