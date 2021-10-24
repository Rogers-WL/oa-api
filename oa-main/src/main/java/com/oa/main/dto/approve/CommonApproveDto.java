package com.oa.main.dto.approve;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author rogers
 */
@Data
@NoArgsConstructor
public class CommonApproveDto {

    @NotBlank(message = "审批对象id不能为空")
    private String id;

    @NotNull(message = "是否通过必填")
    private Boolean isAgree;

    @ApiModelProperty("审批通过不要显示输入框")
    private String reason;
}
