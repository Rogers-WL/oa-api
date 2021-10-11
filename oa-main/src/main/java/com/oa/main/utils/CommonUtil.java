package com.oa.main.utils;

import com.oa.common.utils.SecurityUtils;
import com.oa.main.doman.BaseDo;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author rogers
 */
public class CommonUtil {

    public static String generateId() {
       return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }

    public static void setCreateAndUpdateInfo(BaseDo baseDo, boolean isCreate) {
        LocalDateTime now = LocalDateTime.now();
        if (isCreate) {
            baseDo.setCreateBy(SecurityUtils.getUsername());
            baseDo.setCreateByName(SecurityUtils.getUserShowName());
            baseDo.setCreateTime(now);
        }
        baseDo.setUpdateBy(SecurityUtils.getUsername());
        baseDo.setUpdateByName(SecurityUtils.getUserShowName());
        baseDo.setUpdateTime(now);
    }


}
