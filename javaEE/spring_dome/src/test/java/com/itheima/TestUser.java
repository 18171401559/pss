package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima
 * @Author: PengSS
 * @CreateTime: 2018-09-14 13:27
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestUser {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
      /*ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService as = ac.getBean(UserService.class);*/
        List<User> list = userService.findAll();
        System.out.println(list);
    }
}
