package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 根据用户名和密码查询数据库
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id删除
     * @param id
     */
    void delete(int id);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 更新用户数据
     * @param user
     */
    void update(User user);

    /**
     * 根据id批量删除用户
     * @param ids
     */
    void deleteByIds(String[] ids);

    /**
     * 分页查询数据
     * @param start
     * @param rows
     * @return
     */
    List<User> findByPage(Integer start, Integer rows);

    /**
     * 查询数据总条数
     * @return
     */
    int findTotalCount();

    /**
     * 根据条件分页查询用户信息
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, Integer rows, User condition);

    /**
     * 根据条件,分页查询用户数量
     * @param condition
     * @return
     */
    int findTotalCount(User condition);
}
