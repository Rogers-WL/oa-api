package com.oa.main.service.sale;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.common.config.response.R;
import com.oa.main.doman.sale.SaleWorkLogDo;
import com.oa.main.dto.sale.SaleWorkLogDto;

/**
 * 【请填写功能名称】 Service接口
 *
 * @author rogers
 * @date 2021-09-26
 */
public interface ISaleWorkLogService extends IService<SaleWorkLogDo> {

    R save(SaleWorkLogDto dto);

    R del(String ids);

    R recall(String id);

    R manager(SaleWorkLogDto dto);

    R boss(SaleWorkLogDto dto);
}
