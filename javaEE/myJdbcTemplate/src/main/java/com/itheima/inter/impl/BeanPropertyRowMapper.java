package com.itheima.inter.impl;

import com.itheima.inter.RowMapper;

import java.lang.reflect.InvocationTargetException;

/**
 * @Package: com.itheima.inter.impl
 * @Author: PengSS
 * @Date: 2018/10/26 13:11
 */
public class BeanPropertyRowMapper<T> implements RowMapper{
    private Class<T> clazz;

    public BeanPropertyRowMapper(Class<T> tClassclazz) {
        this.clazz = tClassclazz;
    }

    public Class<T> getClazz() {
        return clazz;
    }
}
