package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

/**
 * @Package: com.itheima.test
 * @Author: PengSS
 * @Date: 2018/11/4 21:35
 */
public class Test1 {
    public static void main(String[] args) {
        //创建对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        System.out.println("欢迎进入联系人管理系统");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //定义sql语句
        String sql = "select * from user where name =? and password =?";
        try {
            User u = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
            System.out.println("欢迎您！" + u.getName());
        } catch (Exception e) {
            System.out.println("用户名或者密码错误");
        }
    }
}
