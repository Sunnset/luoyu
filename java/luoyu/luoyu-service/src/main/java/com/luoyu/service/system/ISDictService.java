package com.luoyu.service.system;

import com.luoyu.common.entity.system.SDict;

public interface ISDictService {
    /**
     * 添加字典项
     * @param dict 字典项信息
     * @return 差让人数量
     */
    public int insert(SDict dict);
}
