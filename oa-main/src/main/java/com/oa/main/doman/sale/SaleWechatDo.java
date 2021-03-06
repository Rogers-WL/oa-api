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

/**
 * 【请填写功能名称】 对象 sale_wechat
 *
 * @author rogers
 * @date 2021-09-26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sale_wechat")
public class SaleWechatDo extends BaseDo implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id")
    private String id;

    private String account;

    private String password;

    private String owner;

    private String ownerName;

    /**
     * 0正常1禁用
     */
    private Integer status;

}
