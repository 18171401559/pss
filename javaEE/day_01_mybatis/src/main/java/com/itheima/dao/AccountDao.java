package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima.dao
 * @Author: PengSS
 * @CreateTime: 2018-09-12 23:22
 * @Description: ${Description}
 */

public interface AccountDao {
    /**
     * 查询所有的账户以及账户对应的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(value = {@Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),              //账户和角色通过uid链接，通过uid,查询uid所对应的id的user,一个账户对应一个user,多对一采用立即加载
            @Result(property = "user",column = "uid",one = @One(select = "com.itheima.dao.UserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAccountUser();

    /**
     * 查询所有的用户以及用户对应的角色
     * @return
     */
    List<User> findAll();
}
