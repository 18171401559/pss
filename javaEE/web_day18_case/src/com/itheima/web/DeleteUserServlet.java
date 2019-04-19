package com.itheima.web;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收请求参数
        String id = request.getParameter("id");

        //2. 调用业务层处理数据
        UserService userService = new UserServiceImpl() ;
        userService.delete(Integer.parseInt(id));

        //3. 进行页面跳转
        response.sendRedirect(request.getContextPath()+"/search");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
