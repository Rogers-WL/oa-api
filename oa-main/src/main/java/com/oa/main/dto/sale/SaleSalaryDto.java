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
public class SaleSalaryDto implements Serializable {

private static final long serialVersionUID=1L;


    private String id;


    private Integer year;


    private Integer month;


    private String user;


    private String userName;


    private BigDecimal baseSalary;


    private BigDecimal orderBonus;


    private BigDecimal bonus;


    private BigDecimal deduct;


    private String remark;

    private String createTime;

}
