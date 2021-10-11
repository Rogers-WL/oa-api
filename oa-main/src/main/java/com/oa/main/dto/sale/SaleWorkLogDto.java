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
public class SaleWorkLogDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String finishedWork;

    private String needHelpWork;

    private String remark;

    @ApiModelProperty("0已审阅1组长审阅2主管审阅3boss审阅")
    private Integer status;

    private String leaderComment;

    private String createTime;
}
