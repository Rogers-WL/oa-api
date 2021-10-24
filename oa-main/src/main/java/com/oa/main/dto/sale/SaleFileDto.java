package com.oa.main.dto.sale;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 【请填写功能名称】 实体
 *
 * @author rogers
 * @date 2021-09-26
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("【请填写功能名称】")
public class SaleFileDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String url;

    private String type;


}
