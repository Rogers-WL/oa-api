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
public class SaleWorkLeaveDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty("精确到秒的格式")
    @NotBlank(message = "请假开始时间不能为空")
    private String startTime;

    @ApiModelProperty("精确到秒的格式")
    @NotBlank(message = "请假结束时间不能为空")
    private String endTime;

    @ApiModelProperty("请假类型")
    private String type;

    @NotBlank(message = "请假理由不能为空")
    private String reason;

    @ApiModelProperty("0已通过1未通过2申请取消3主管审批4boss审批5人事审批")
    private Integer status;

    private String handler;

    private String handlerName;

    private String unpassComment;

    @ApiModelProperty("我的请假查询")
    private String createBy;

    private String createByName;

    private String createTime;
}
