package com.luoyu.dao.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wangzb
 * @program: luoyu
 * @description 通用mapper
 * @create: 2021-05-05 19:46
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
