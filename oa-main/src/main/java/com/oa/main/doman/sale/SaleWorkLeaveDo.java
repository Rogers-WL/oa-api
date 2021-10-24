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
import java.time.LocalDateTime;

/**
 * 【请填写功能名称】 对象 sale_work_leave
 * 
 * @author rogers
 * @date 2021-09-26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sale_work_leave")
public class SaleWorkLeaveDo extends BaseDo implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private String id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String type;

    private String reason;

    /** 0已通过1未通过2申请取消3主管审批4boss审批5人事审批 */
    private Integer status;

    private String handler;

    private String handlerName;

    private String unpassComment;
}
