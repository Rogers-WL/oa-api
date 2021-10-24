package com.oa.main.dto.sale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oa.framework.web.domain.server.SysFile;
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
import java.util.List;

/**
 * 【请填写功能名称】 实体
 * 
 * @author rogers
 * @date 2021-09-26
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("新客登记")
public class SaleNewCustomerDto implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    @ApiModelProperty("必填")
    @NotBlank(message = "日期不能为空")
    private String date;

    @ApiModelProperty("必选，可作搜索条件，模糊")
    @NotBlank(message = "微信号不能为空")
    private String wechat;

    @ApiModelProperty("必填")
    @NotNull(message = "数量不能为空")
    private Long amount;

    private String remark;

    @ApiModelProperty("可作搜索条件，精确")
    private String createBy;

    private String createTime;

    private List<SaleFileDto> picList;

}
