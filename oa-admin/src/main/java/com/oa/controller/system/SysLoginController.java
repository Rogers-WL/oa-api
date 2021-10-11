package com.oa.controller.system;

import java.util.List;
import java.util.Set;

import com.oa.common.config.response.CustomR;
import com.oa.common.config.response.R;
import com.oa.common.constant.Constants;
import com.oa.common.core.domain.model.LoginBody;
import com.oa.common.utils.SecurityUtils;
import com.oa.framework.web.service.SysLoginService;
import com.oa.framework.web.service.SysPermissionService;
import com.oa.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.oa.common.core.domain.entity.SysMenu;
import com.oa.common.core.domain.entity.SysUser;

/**
 * 登录验证
 * 
 * @author rogers
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public CustomR login(@RequestBody LoginBody loginBody)
    {
        CustomR r = CustomR.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        r.put(Constants.TOKEN, token);
        return r;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public CustomR getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        CustomR ajax = CustomR.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public R getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return R.success(menuService.buildMenus(menus));
    }
}
