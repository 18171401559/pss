package com.itheima.dao;

import com.itheima.domian.User;
import com.itheima.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Package: com.itheima.dao
 * @Author: PengSS
 * @Date: 2018/9/26 15:07
 */
public class UserDao {

    public User login(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
     return  queryRunner.query("select * from user where username = ? and password = ?",new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
    }
}
