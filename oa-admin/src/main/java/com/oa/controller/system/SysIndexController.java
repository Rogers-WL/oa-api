package com.oa.controller.system;

import com.oa.common.config.OaConfig;
import com.oa.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author rogers
 */
@RestController
public class SysIndexController
{
    /** 系统基础配置 */
    @Autowired
    private OaConfig oaConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", oaConfig.getName(), oaConfig.getVersion());
    }
}
