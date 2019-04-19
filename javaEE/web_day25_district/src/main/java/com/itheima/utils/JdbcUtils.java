package com.itheima.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private  static DataSource dataSource ;

    static {
        try {
            //1. 加载配置文件
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //2. 创建Properties对象加载数据
            Properties properties = new Properties();
            properties.load(is);

            //3. 初始化连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池
     * @return
     */
    public static  DataSource getDataSource(){
        return  dataSource ;
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
