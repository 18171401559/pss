package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {

    private static DataSource dataSource = new ComboPooledDataSource() ;

    /**
     * 获取连接
     * @return
     */
    public  static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return  connection ;
    }


    /**
     * 获取连接池的方法
     * @return
     */
    public  static  DataSource getDataSource(){
        return  dataSource ;
    }

}
