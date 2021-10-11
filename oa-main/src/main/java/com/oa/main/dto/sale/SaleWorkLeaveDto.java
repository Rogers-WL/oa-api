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
public class SaleWorkLeaveDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String startTime;

    private String endTime;

    private String reason;

    @ApiModelProperty("0已通过1未通过2申请取消3组长审批4主管审批5boss审批6人事审批")
    private Integer status;

    private String createTime;
}
