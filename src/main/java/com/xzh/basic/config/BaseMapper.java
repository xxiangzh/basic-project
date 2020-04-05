package com.xzh.basic.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper
 *
 * @author: 向振华
 * @date: 2019/11/12 14:02
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
