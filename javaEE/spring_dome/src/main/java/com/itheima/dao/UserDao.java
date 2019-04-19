package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima.dao
 * @Author: PengSS
 * @CreateTime: 2018-09-14 13:32
 * @Description: ${Description}
 */
@Repository
public interface UserDao {

    /**
     * 查询所有用户的方法
     * @return
     */
    @Select("selet * from user")
    List<User> findAll();
}
