package com.itheima.jdbc;

import com.itheima.inter.impl.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.itheima.jdbc
 * @Author: PengSS
 * @Date: 2018/10/26 13:12
 */
public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int update(String sql, Object... params) {
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            int rows = pstmt.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public <T> T queryForObject(String sql, BeanPropertyRowMapper<T> beanPropertyRowMapper, Object... params) {
        try {
            //从连接池获取连接
            Connection con = dataSource.getConnection();
            //预编译sql
            PreparedStatement pstmt = con.prepareStatement(sql);
            //替换占位符
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            //执行sql,获取结果集
            ResultSet resultSet = pstmt.executeQuery();
            //获取字节码对象
            Class c = beanPropertyRowMapper.getClazz();
            //获取实例化对象
            Object t = c.getDeclaredConstructor().newInstance();
            //通过字节码对象获取所有的字段
            Field[] fields = c.getDeclaredFields();
            while (resultSet.next()) {
                //遍历所有的字段
                for (int i1 = 0; i1 < fields.length; i1++) {
                    //获取每一个字段
                    Field f = fields[i1];
                    //开启暴力反射
                    f.setAccessible(true);
                    //给字段赋值
                    Object o = resultSet.getObject(i1 + 1);
                    f.set(t, o);
                }
            }
            return (T) t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> query(String sql, BeanPropertyRowMapper<T> beanPropertyRowMapper) {
        List<T> list = new ArrayList<T>();
        //从连接池获取连接
        try {
            Connection con = dataSource.getConnection();
            //预编译sql
            PreparedStatement pstmt = con.prepareStatement(sql);
            //执行sql,获取结果集
            ResultSet resultSet = pstmt.executeQuery();
            //获取字节码对象
            Class c = beanPropertyRowMapper.getClazz();

            //通过字节码对象获取所有的字段
            Field[] fields = c.getDeclaredFields();

            while (resultSet.next()) {
                //获取实例化对象
                Object t = c.getDeclaredConstructor().newInstance();
                //遍历所有的字段
                for (int i1 = 0; i1 < fields.length; i1++) {
                    //获取每一个字段
                    Field f = fields[i1];
                    //开启暴力反射
                    f.setAccessible(true);
                    //给字段赋值
                    Object o = resultSet.getObject(i1 + 1);
                    f.set(t, o);
                }
                list.add((T) t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
