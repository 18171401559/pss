package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.Account;
import com.itheima.domain.Role;
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
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima
 * @Author: PengSS
 * @CreateTime: 2018-09-11 16:21
 * @Description: ${Description}
 */
public class MybatisTest {
    SqlSession session;
    UserDao userDao;

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
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void after() {
        session.commit();
        session.close();
    }

    public static void main(String[] args) throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession();
        //5.使用 SqlSession 创建 dao 接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //6.使用代理对象执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //7.释放资源
        session.close();
        in.close();
    }

    /**
     * 查询所有用户
     */
    @Test
    public void test1() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 添加用户
     */
    @Test
    public void test2() {
        User user = new User();
        user.setUsername("猪八戒");
        user.setSex("男");
        user.setAddress("高老庄");
        user.setBirthday(new Date());
        userDao.save(user);
        System.out.println(user.getId());
    }

    /**
     * 更新用户
     */

    @Test
    public void test3() {
        User user = new User();
        user.setUsername("吴语泰");
        user.setId(52);
        user.setSex("男");
        user.setAddress("光谷经融港");
        user.setBirthday(new Date());
        userDao.update(user);
    }

    /**
     * 删除用户
     */
    @Test
    public void test4() {
        userDao.delete(52);
    }

    /**
     * 根据用户id查询用户
     */
    @Test
    public void test5() {
        User user = userDao.findById(51);
        System.out.println(user);
    }

    /**
     * 根据名字模糊查询
     */
    @Test
    public void test6() {
       List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询总记录条数
     */
    @Test
    public void test7() {
      int count = userDao.findTotalCount();
        System.out.println(count);
    }

    /**
     * 查询所有的用户信息以及对应的角色信息
     */
    @Test
    public void test8() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            List<Role> roles = user.getRoles();
            System.out.println(roles);
        }
    }
}
