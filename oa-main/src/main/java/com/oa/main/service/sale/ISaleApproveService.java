package com.oa.main.service.sale;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.common.config.response.R;
import com.oa.main.doman.sale.SaleApproveDo;
import com.oa.main.doman.sale.SaleGroupDo;
import com.oa.main.dto.sale.SaleApproveDto;
import com.oa.main.dto.sale.SaleGroupDto;

/**
 * 【请填写功能名称】 Service接口
 *
 * @author rogers
 * @date 2021-09-26
 */
public interface ISaleApproveService extends IService<SaleApproveDo> {

    R save(SaleApproveDto dto);

    R del(String ids);
}
