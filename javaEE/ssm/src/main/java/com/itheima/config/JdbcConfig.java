package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 数据库链接池的配置类
 */
//此注解用于指定dao接口所指定的包
@MapperScan("com.itheima.dao")
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 配置sessionfectory
     */
    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }


    /**
     * 配置连接池对象c3p0连接池
     */
    @Bean
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        return comboPooledDataSource;
    }


}
