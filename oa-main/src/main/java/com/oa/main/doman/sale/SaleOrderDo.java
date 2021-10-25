package com.oa.main.doman.sale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oa.main.doman.BaseDo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 【请填写功能名称】 对象 sale_order
 * 
 * @author rogers
 * @date 2021-09-26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sale_order")
public class SaleOrderDo extends BaseDo implements Serializable {

private static final long serialVersionUID=1L;



    @TableId(value = "id")
    private String id;


    private String orderNo;


    private String product;

    private String receiveAddress;


    private String customerName;


    private String customerPhone;


    private BigDecimal orderPrice;

    /** 0全款1定金 */
    private Integer payType;


    private BigDecimal payMoney;

    private BigDecimal restMoney;

    private BigDecimal validMoney;


    private String remark;

    /** 0已签收1已拒收2订单取消3主管确认4boos确认5审批未通过6待发货7待收货 */
    private Integer status;


}
