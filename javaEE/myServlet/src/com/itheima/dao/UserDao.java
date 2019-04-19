package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Package: com.itheima.dao
 * @Author: PengSS
 * @Date: 2018/11/20 11:18
 */
//用于访问数据库
public class UserDao {
    //获取JdbcTemplate对象
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    //定义一个方法，用于查询数据库中是否有这个用户
    public User login(User u) {
        //user{name=zhangsan,password=123}
        //查询数据库，先写sql
        String sql = "select * from user where name =? and password = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), u.getName(), u.getPassword());
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
