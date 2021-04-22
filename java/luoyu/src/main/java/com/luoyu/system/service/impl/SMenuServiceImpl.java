package com.luoyu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luoyu.common.environment.BaseEnvironment;
import com.luoyu.common.pojo.system.SMenu;
import com.luoyu.system.mapper.SMenuMapper;
import com.luoyu.system.service.ISMenuSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangzb
 * @description 菜单服务接口
 * @create: 2020-10-17 16:35
 */
@Service
public class SMenuServiceImpl implements ISMenuSerevice {

    @Autowired
    private SMenuMapper menuMapper;
    /**
     * 获取当前登录用户授权的菜单
     * @param userId 用户唯一标识
     * @return list
     */
    @Override
    public List<SMenu> getLoginUserMenu(Integer userId) {
        QueryWrapper<SMenu> queryWrapper = new QueryWrapper<>();
        //默认查找开启和未删除的菜单列表
        queryWrapper.eq("OPEN_FLAG", BaseEnvironment.OPEN_STATUS);
        queryWrapper.eq("DELETE_FLAG", BaseEnvironment.UNDELETE_STATUS);
        queryWrapper.orderByAsc("MENU_LEVEL", "MENU_ORDER_NUM");
        return menuMapper.selectList(queryWrapper);
    }
}
