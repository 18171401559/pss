package com.itheima.dao;

import com.itheima.domian.User;
import com.itheima.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * @Package: com.itheima.dao
 * @Author: PengSS
 * @Date: 2018/9/26 15:07
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    public User login(User user) throws SQLException {
        try {
            return template.queryForObject("select * from user where username = ? and password = ?", new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        } catch (Exception e) {
            return null;
        }

    }
}
