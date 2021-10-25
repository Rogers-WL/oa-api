package com.oa.main.dto.approve;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author rogers
 */
@Data
@NoArgsConstructor
public class CommonOrderDto {

    @NotBlank(message = "id不能为空")
    private String id;

    @NotNull(message = "1取消订单2发货3签收4拒收；只有订单状态是3的时候才有取消订单按钮")
    private Integer type;

}
