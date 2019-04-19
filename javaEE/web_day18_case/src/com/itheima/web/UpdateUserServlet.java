package com.itheima.web;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 解决中文乱码
        request.setCharacterEncoding("UTF-8");
        //2. 接收参数
        Map<String, String[]> map = request.getParameterMap();
        //3. 封装数据
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //4. 调用业务层进行业务处理
        UserService userService = new UserServiceImpl() ;
        userService.update(user);

        //5. 跳转页面
        response.sendRedirect(request.getContextPath()+"/search");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
