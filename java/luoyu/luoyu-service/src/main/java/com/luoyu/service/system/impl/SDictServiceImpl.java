package com.luoyu.service.system.impl;

import com.luoyu.common.entity.system.SDict;
import com.luoyu.dao.mapper.system.SDictMapper;
import com.luoyu.service.system.ISDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangzb
 * @program: luoyu
 * @description 系统字典项service
 * @create: 2021-05-05 21:26
 */
@Service
public class SDictServiceImpl implements ISDictService {

    @Autowired
    private SDictMapper dictMapper;
    /**
     * 添加字典项
     *
     * @param dict 字典项信息
     * @return 差让人数量
     */
    @Override
    public int insert(SDict dict) {
        return dictMapper.insert(dict);
    }
}
