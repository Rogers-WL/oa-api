package com.oa.main.service.sale;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.common.config.response.R;
import com.oa.main.doman.sale.SaleOrderDo;
import com.oa.main.dto.approve.CommonApproveDto;
import com.oa.main.dto.approve.CommonOrderDto;
import com.oa.main.dto.sale.SaleOrderDto;

/**
 * 【请填写功能名称】 Service接口
 *
 * @author rogers
 * @date 2021-09-26
 */
public interface ISaleOrderService extends IService<SaleOrderDo> {

    R save(SaleOrderDto dto);

    R del(String ids);

    R approve(CommonApproveDto approveDto);

    R operateOrder(CommonOrderDto dto);
}
