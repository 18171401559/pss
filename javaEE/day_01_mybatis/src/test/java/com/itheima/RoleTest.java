package com.itheima;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
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
 * @CreateTime: 2018-09-13 13:32
 * @Description: ${Description}
 */
public class RoleTest {
    SqlSession session;
    RoleDao roleDao;

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
        roleDao = session.getMapper(RoleDao.class);
    }

    @After
    public void after() {
        session.commit();
        session.close();
    }

    /**
     * 测试查询所有的角色以及角色对应的用户
     */
    @Test
    public void test1(){
       List<Role> list = roleDao.findAll();
        for (Role role : list) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

}
