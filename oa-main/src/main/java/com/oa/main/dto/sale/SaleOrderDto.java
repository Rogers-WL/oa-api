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
@ApiModel("【请填写功能名称】")
public class SaleOrderDto implements Serializable {

private static final long serialVersionUID=1L;


    private String id;

    private String orderNo;

    private String product;

    private String receiveAddress;

    private String customerName;

    private String customerPhone;

    private BigDecimal orderPrice;

    @ApiModelProperty("0全款1定金")
    private Integer payType;

    private BigDecimal payMoney;

    private BigDecimal restMoney;

    private BigDecimal validMoney;

    private String remark;

    @ApiModelProperty("0已签收1已拒收2订单取消3主管确认4boos确认5待发货6待收货")
    private Integer status;

    private String createTime;
}
