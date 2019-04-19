package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private  JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public User findByUsernameAndPassword(String username, String password) {

        String sql = "SELECT * FROM USER WHERE username = ? AND PASSWORD = ? " ;
        try {
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return  user ;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user" ;
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE  FROM USER WHERE id = ? " ;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void add(User user) {
        String sql  = "INSERT  INTO `user`VALUES (NULL,?,?,?,?,?,?,NULL,NULL)";
        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM USER WHERE id = ? " ;
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE USER SET NAME = ? ,gender = ? ,age = ? ,address = ? ,qq = ? ,email = ? WHERE id = ? " ;
        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    // [1,2,3,4] DELETE  FROM USER WHERE id in (1,2,3,4)
    @Override
    public void deleteByIds(String[] ids) {
        StringBuilder sb = new StringBuilder("DELETE  FROM USER WHERE id in ( ") ;
        for (String id : ids) {
            sb.append("?,");//(1,2,3,4,
        }
        //删除最后一个,
        sb.deleteCharAt(sb.length()-1);//(1,2,3,4
        //追加最后一个)
        sb.append(")");//DELETE  FROM USER WHERE id in (?,?,?,?);
        //执行删除
        jdbcTemplate.update(sb.toString(),ids);
    }

    @Override
    public List<User> findByPage(Integer start, Integer rows) {
        String sql = "select * from user limit ?,?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), start, rows);
        return users;
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from user ";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> findByPage(int start, Integer rows, User condition) {
        //定义sql模版
        StringBuilder sb = new StringBuilder("select * from user where 1 = 1 ");
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        //判断参数中是否有用户名,如果有,需要根据名称查询
        String name = condition.getName() ;
        if(name!=null && !"".equals(name)){
            sb.append(" and name like ? ");
            params.add("%"+name+"%");
        }

        //判断参数中是否有地址
        String address = condition.getAddress();
        if(address!=null && !"".equals(address)){
            sb.append(" and address like ? ");
            params.add("%"+address+"%");
        }

        //判断参数中是否有邮箱
        String email = condition.getEmail();
        if(email!=null && !"".equals(email)){
            sb.append(" and email like ? ");
            params.add("%"+email+"%");
        }

        //追加分页查询SQL语句
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);

        List<User> users = jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());

        return users;
    }

    @Override
    public int findTotalCount(User condition) {
        //定义sql模版
        StringBuilder sb = new StringBuilder("select count(*) from user where 1 = 1 ");
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        //判断参数中是否有用户名,如果有需要根据名称查询
        String name = condition.getName() ;
        if(name!=null && !"".equals(name)){
            sb.append(" and name like ? ");
            params.add("%"+name+"%");
        }

        //判断参数中是否有地址,如果有需要根据地址查询
        String address = condition.getAddress();
        if(address!=null && !"".equals(address)){
            sb.append(" and address like ? ");
            params.add("%"+address+"%");
        }

        //判断参数中是否有邮箱,如果有需要根据邮箱查询
        String email = condition.getEmail();
        if(email!=null && !"".equals(email)){
            sb.append(" and email like ? ");
            params.add("%"+email+"%");
        }

        return jdbcTemplate.queryForObject(sb.toString(),Integer.class,params.toArray());
    }
}
