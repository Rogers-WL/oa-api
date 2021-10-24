package com.oa.main.service.sale;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.common.config.response.R;
import com.oa.main.doman.sale.SaleWorkLeaveDo;
import com.oa.main.dto.approve.CommonApproveDto;
import com.oa.main.dto.sale.SaleWorkLeaveDto;

/**
 * 【请填写功能名称】 Service接口
 *
 * @author rogers
 * @date 2021-09-26
 */
public interface ISaleWorkLeaveService extends IService<SaleWorkLeaveDo> {

    R save(SaleWorkLeaveDto dto);

    R del(String ids);


    /**
     * 审批
     *
     * @author rogers
     * @date  2021/10/24 14:10
     */
    R approve(CommonApproveDto dto);
}
