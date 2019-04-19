package com.itheima.web;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Package: ${PACKAGE_NAME}
 * @Author: PengSS
 * @Date: 2018/11/20 11:09
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //后台生成的验证码
        String code = (String) getServletContext().getAttribute("code");
        //从前台获取验证码
        String verifycode = request.getParameter("verifycode");
        if (!code.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            request.getRequestDispatcher("yanzhengma.html").forward(request, response);
            return;
        }

        //获取前端穿过来的数据，封装到map中
        //name:name值
        //password:密码
        Map<String, String[]> map = request.getParameterMap();
        /*
         * name = zhangsan
         * password = 123
         * */
        User user = new User();
        //user空
        try {
            //把接受到的数据封装到user对象中
            BeanUtils.populate(user, map);
            //user{name=zhangsan,password=123}
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //去数据库查询，有没有这条记录
        UserDao userDao = new UserDao();
        User loginUser = userDao.login(user);
        //loginUser如果在数据库中查到了数据，就返回一个具体对象，没查到就返回null
        if (loginUser == null) {
            //登陆失败
            request.getRequestDispatcher("shibai.html").forward(request, response);
        } else {
            //登陆成功
            request.getRequestDispatcher("chenggong.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
