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
 * 【请填写功能名称】 对象 sale_work_log
 * 
 * @author rogers
 * @date 2021-09-26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sale_work_log")
public class SaleWorkLogDo extends BaseDo implements Serializable {

private static final long serialVersionUID=1L;


    @TableId(value = "id")
    private String id;

    private String finishedWork;

    private String needHelpWork;

    private String remark;

    /** 0已审阅1已撤回2主管审阅3boss审阅 */
    private Integer status;

    private String manager;
    private String managerName;
    private String managerComment;
    private LocalDateTime managerTime;
    private String boss;
    private String bossName;
    private String bossComment;
    private LocalDateTime bossTime;

}
