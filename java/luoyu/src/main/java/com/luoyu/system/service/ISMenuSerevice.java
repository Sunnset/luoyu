package com.luoyu.system.service;

import com.luoyu.common.pojo.system.SMenu;

import java.util.List;

public interface ISMenuSerevice {

    /**
     * 获取当前登录用户授权的菜单
     * @param userId 用户唯一标识
     * @return list
     */
    public List<SMenu> getLoginUserMenu(Integer userId);
}
