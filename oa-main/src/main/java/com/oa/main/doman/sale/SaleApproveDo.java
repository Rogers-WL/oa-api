package com.oa.main.doman.sale;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.oa.main.doman.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 【请填写功能名称】 对象 sale_approve
 *
 * @author rogers
 * @date 2021-09-26
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sale_approve")
public class SaleApproveDo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    private String masterId;

    /** 0请假1工作体制 */
    private Integer type;

    private Boolean isApprove;

    private String remark;

    private String handler;

    private String handlerName;

    private LocalDateTime handleTime;

}
