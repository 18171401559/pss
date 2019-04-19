package com.itheima.test;

import com.itheima.domain.Contact;
import com.itheima.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Package: com.itheima.test
 * @Author: PengSS
 * @Date: 2018/11/4 21:49
 */
public class Test2 {
    public static void main(String[] args) {
        //创建对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

        String sql ="select * from contact";
        List<Contact> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class));
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }
}
