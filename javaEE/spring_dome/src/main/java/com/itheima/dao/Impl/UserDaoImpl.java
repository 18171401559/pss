package com.itheima.dao.Impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima.dao.Impl
 * @Author: PengSS
 * @CreateTime: 2018-09-14 13:55
 * @Description: ${Description}
 */
@Repository
public class UserDaoImpl implements UserDao{

   @Autowired
   private QueryRunner queryRunner;

    @Override
    public List<User> findAll() {
        try {
            return queryRunner.query("select * from user",new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
