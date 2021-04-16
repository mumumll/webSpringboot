package com.mumu.demo.common;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author mumu
 * @Description: mybatis自动生成数据库相关实体类
 * @date 2021/4/1 16:39
 */
public interface MySqlExtensionMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
