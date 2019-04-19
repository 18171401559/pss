package com.itheima.test;

import com.itheima.domain.T_product;
import com.itheima.inter.RowMapper;
import com.itheima.inter.impl.DBType;
import com.itheima.inter.impl.JdbcTemplate;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * @Package: com.itheima.test
 * @Author: PengSS
 * @Date: 2018/10/26 10:56
 */
public class JdbcTemplateTest {
    JdbcTemplate jdbcTemplate = null;

    @Before
    public void before() {
        jdbcTemplate = new JdbcTemplate(DBType.MYSQL);
        jdbcTemplate.setConnectionUrl("jdbc:mysql:///web_crud");
        jdbcTemplate.setUserName("root");
        jdbcTemplate.setPassword("123");
    }

    @Test
    public void test1() {
        String strSql = "SELECT * FROM t_product";
        List<Properties> list = jdbcTemplate.executeQuery(strSql);
        System.out.println(list);
    }

    @Test
    public void test2() throws SQLException {
        String strSql = "update t_product set name = ? where id = ?";
        jdbcTemplate.update(strSql, "张三", 7);
    }
}
