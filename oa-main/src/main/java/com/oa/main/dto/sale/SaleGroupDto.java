package com.oa.main.dto.sale;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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
public class SaleGroupDto implements Serializable {

private static final long serialVersionUID=1L;


    private String id;

    @NotBlank(message = "销售小组名称不能为空")
    private String name;

    private String remark;


    private String managerAccount;

    @NotBlank(message = "销售小组组长不能为空，影响审批")
    private String managerName;

    private String createTime;

}
