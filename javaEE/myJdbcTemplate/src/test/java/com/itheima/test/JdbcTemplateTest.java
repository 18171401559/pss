package com.itheima.test;

import com.itheima.domain.T_product;
import com.itheima.inter.impl.BeanPropertyRowMapper;
import com.itheima.jdbc.JdbcTemplate;
import com.itheima.utils.JDBCUtils;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.List;

/**
 * @Package: com.itheima.test
 * @Author: PengSS
 * @Date: 2018/10/26 13:15
 */
public class JdbcTemplateTest {

    @Test
    public void test1() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        int rows = jdbcTemplate.update("update T_product set company = ? where id =?", "小米", 7);
        System.out.println(rows);
    }

    @Test
    public void test2() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        T_product product = jdbcTemplate.queryForObject("select * from T_Product where id = ?", new BeanPropertyRowMapper<T_product>(T_product.class), 7);
        System.out.println(product);
    }

    @Test
    public void test3() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        List<T_product> product = jdbcTemplate.query("select * from T_Product", new BeanPropertyRowMapper<T_product>(T_product.class));
        System.out.println(product);
    }

    @Test
    public void test4() {
//创建mongodb 客户端
        MongoClient mongoClient = new MongoClient("localhost", 27017);
//或者采用连接字符串
        // MongoClientURI connectionString = new MongoClientURI("mongodb://root:root@localhost:27017");
//
        MongoDatabase database = mongoClient.getDatabase("test");
// 连接collection
        database.createCollection("student");
//查询第一个文档
        // Document myDoc = collection.find().first();
//得到文件内容 json串
        //String json = myDoc.toJson();
        //System.out.println(json);
    }
}
