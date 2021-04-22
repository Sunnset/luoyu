package com.luoyu.system.controller;

import com.luoyu.common.pojo.system.SMenu;
import com.luoyu.system.service.ISMenuSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wangzb
 * @description 菜单controller
 * @create: 2020-10-13 21:12
 */

@Controller
@RequestMapping(value = "/system/menu")
public class MenuController {

    @Autowired
    private ISMenuSerevice menuSerevice;

    /**
     * 获取登录用户的菜单
     * @return
     */
    @RequestMapping(value = "/loginUserMenu")
    public @ResponseBody List<SMenu> getLoginUserMenu(HttpServletRequest request){
        List<SMenu> menus = menuSerevice.getLoginUserMenu(null);
        return menus;
    }
}
