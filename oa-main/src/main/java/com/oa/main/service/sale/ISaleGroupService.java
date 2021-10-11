package com.oa.main.service.sale;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.common.config.response.R;
import com.oa.main.doman.sale.SaleGroupDo;
import com.oa.main.dto.sale.SaleGroupDto;

/**
 * 【请填写功能名称】 Service接口
 *
 * @author rogers
 * @date 2021-09-26
 */
public interface ISaleGroupService extends IService<SaleGroupDo> {

    R save(SaleGroupDto dto);

    R del(String ids);

    R getSales(String id);
}
