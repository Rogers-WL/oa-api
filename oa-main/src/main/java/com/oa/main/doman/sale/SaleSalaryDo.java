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
 * 【请填写功能名称】 对象 sale_salary
 * 
 * @author rogers
 * @date 2021-09-26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sale_salary")
public class SaleSalaryDo extends BaseDo implements Serializable {

private static final long serialVersionUID=1L;


    @TableId(value = "id")
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



}
