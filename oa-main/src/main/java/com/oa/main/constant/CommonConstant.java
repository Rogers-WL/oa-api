package com.oa.main.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rogers
 */
public class CommonConstant {

    public static final String SQL_DEFAULT_ORDER = "create_time desc";

    public static final String ROLE_SALESMAN = "salesman";
    public static final String ROLE_SALESMAN_GM = "salesman_gm";
    public static final String ROLE_MANAGER = "manager";
    public static final String ROLE_BOSS = "boss";
    public static final String ROLE_DELIVER = "deliver";
    public static final String ROLE_HR = "hr";

    /** 请假类型 */
    public static final List<String> WORK_LEAVE_TYPE = new ArrayList<>();

    static {
        WORK_LEAVE_TYPE.add("事假");
        WORK_LEAVE_TYPE.add("病假");
    }

}
