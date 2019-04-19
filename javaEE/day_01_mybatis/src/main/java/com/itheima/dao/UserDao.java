package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima.UserDao
 * @Author: PengSS
 * @CreateTime: 2018-09-11 16:06
 * @Description: ${Description}
 */
public interface UserDao {
    /**
     * 查询所有的用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user (username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    void save(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username = #{username},birthday=#{birthday},sex=#{sex},address=#{address} where id =#{id}")
    void update(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void delete(int id);

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(int id);

    /**
     * 根据用户名字模糊查询用户
     * @param name
     * @return
     */
    @Select("select * from user where username like '%${value}%'")
    List<User> findByName(String name);

    /**
     * 查询总记录条数
     * @return
     */
    @Select("select count(*) from user")
    int findTotalCount();

}
