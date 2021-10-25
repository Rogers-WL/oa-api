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
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 【请填写功能名称】 实体
 * 
 * @author rogers
 * @date 2021-09-26
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("订单")
public class SaleOrderDto implements Serializable {

private static final long serialVersionUID=1L;


    private String id;

    private String orderNo;

    @NotBlank(message = "产品名称必填")
    private String product;

    @NotBlank(message = "收货地址必填")
    private String receiveAddress;

    @NotBlank(message = "客户名称必填")
    private String customerName;

    @NotBlank(message = "客户电话必填")
    private String customerPhone;

    @NotBlank(message = "订单金额必填")
    private BigDecimal orderPrice;

    @NotNull(message = "付款类型必填")
    @ApiModelProperty("0全款1定金")
    private Integer payType;

    @NotNull(message = "已付金额不能为空")
    private BigDecimal payMoney;

    private BigDecimal restMoney;

    private BigDecimal validMoney;

    private String remark;

    @ApiModelProperty("0已签收1已拒收2订单取消3主管确认4boos确认5审批未通过6待发货7待收货")
    private Integer status;

    private String createBy;

    private String createByName;

    private String createTime;
}
