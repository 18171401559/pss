package com.itheima.config;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima.config
 * @Author: PengSS
 * @CreateTime: 2018-09-14 18:49
 * @Description: ${Description}
 */

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * spring事物的配置类
 */
public class TransactionManagementConfig {

    @Bean
    public DataSourceTransactionManager createTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
