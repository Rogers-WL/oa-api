package com.oa.main.doman;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author rogers
 */
@Data
@NoArgsConstructor
public class BaseDo {

    private String createBy;

    private String createByName;

    private LocalDateTime createTime;

    private String updateBy;

    private String updateByName;

    private LocalDateTime updateTime;
}
