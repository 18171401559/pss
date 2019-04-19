package com.itheima.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Package: com.itheima.utils
 * @Author: PengSS
 * @Date: 2018/11/8 13:45
 */
public class JDBCUtils2 {

    static DataSource ds;

    static {
        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtils2.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接和连接池
    public static DataSource getDataSource() {
        return ds;
    }

    //获取连接，从连接池中获取
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
