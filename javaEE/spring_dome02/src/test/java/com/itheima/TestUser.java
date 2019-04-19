package com.itheima;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * User的测试类
 */

public class TestUser {

    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService as = ac.getBean( UserService.class);
        List<User> all = as.findAll();
        System.out.println(all);
    }
}
