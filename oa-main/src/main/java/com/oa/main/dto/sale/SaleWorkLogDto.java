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
@ApiModel("工作日志")
public class SaleWorkLogDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @NotBlank(message = "已完成工作不能为空")
    private String finishedWork;

    private String needHelpWork;

    private String remark;

    @ApiModelProperty("0已审阅1已撤回2主管审阅3boss审阅")
    private Integer status;


    private List<SaleFileDto> picList;

    private List<SaleFileDto> fileList;

    private String manager;
    private String managerName;
    private String managerComment;
    private String managerTime;
    private String boss;
    private String bossName;
    private String bossComment;
    private String bossTime;

    @ApiModelProperty("我的日志查询条件,精确")
    private String createBy;

    @ApiModelProperty("web端搜条件，模糊")
    private String createByName;

    private String createTime;
}
