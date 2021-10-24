package com.oa.main.doman.sale;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
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
@TableName("sale_file")
public class SaleFileDo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    private String name;

    private String url;

    private String type;

    private String masterId;

    /** workLogPic,workLogFile, newCustomer */
    private String masterType;

    private String createBy;

    private String createByName;

    private LocalDateTime createTime;

}
