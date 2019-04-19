package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima
 * @Author: PengSS
 * @CreateTime: 2018-09-12 23:20
 * @Description: ${Description}
 */
public class AccountTest {
    SqlSession session;
    AccountDao accountDao;

    @Before
    public void before() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        session = factory.openSession();
        //5.使用 SqlSession 创建 dao 接口的代理对象
        accountDao = session.getMapper(AccountDao.class);
    }

    @After
    public void after() {
        session.commit();
        session.close();
    }

    /**
     * 查询账户并查询出账户对应的user信息
     */
    @Test
    public void test1() {
        List<Account> list = accountDao.findAccountUser();
        for (Account account : list) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void test2() {
        List<User> list = accountDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
