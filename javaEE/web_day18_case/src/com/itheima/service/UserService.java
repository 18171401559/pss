package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 用户登录的逻辑操作
     * @param username
     * @param password
     * @return 登录成功返回用户对象,登录失败返回null
     */
    User login(String username, String password);

    /**
     * 查询所有用户信息的业务
     * @return
     */
    List<User> findAll();

    /**
     * 根据id删除用户
     * @param id
     */
    void delete(int id);

    /**
     * 添加用户的业务
     * @param user
     */
    void add(User user);

    /**
     * 根据id查询用户信息业务
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 更具id更新用户的业务
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
     * @param currentPage
     * @param rows
     * @return
     */
    PageBean<User> findByPage(Integer currentPage, Integer rows);

    /**
     * 根据条件搜索用户
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findByPage(Integer currentPage, Integer rows, User condition);
}
