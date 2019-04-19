package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User findById(int id) {
        User user = userDao.findById(id);
        return user;
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    /**
     * @param ids
     */
    @Override
    public void deleteByIds(String[] ids) {
        userDao.deleteByIds(ids);
    }

    @Override
    public PageBean<User> findByPage(Integer currentPage, Integer rows) {
        PageBean<User> pb = new PageBean<User>();
        //封装当前页数据
        pb.setCurrentPage(currentPage);
        //封装数据列表数据
        int start = (currentPage-1)*rows;
        List<User> users = userDao.findByPage(start,rows);
        pb.setList(users);
        //封装数据总条数
        int totalCount = userDao.findTotalCount();
        pb.setTotalCount(totalCount);
        //封装总页数
        int totalPage = (int) Math.ceil(totalCount*1.0/rows);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public PageBean<User> findByPage(Integer currentPage, Integer rows, User condition) {
        PageBean<User> pb = new PageBean<User>();
        //封装当前页数据
        pb.setCurrentPage(currentPage);
        //封装数据列表数据
        int start = (currentPage-1)*rows;
        List<User> users = userDao.findByPage(start,rows,condition);
        pb.setList(users);
        //封装数据总条数
        int totalCount = userDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //封装总页数
        int totalPage = (int) Math.ceil(totalCount*1.0/rows);
        pb.setTotalPage(totalPage);
        return pb;
    }
}
