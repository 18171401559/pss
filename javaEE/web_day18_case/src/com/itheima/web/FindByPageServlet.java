package com.itheima.web;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page")
public class FindByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收参数
        String _currentPage = request.getParameter("currentPage");
        Integer currentPage = 1 ;
        if(_currentPage!=null && !"".equals(_currentPage)){
            currentPage = Integer.parseInt(_currentPage);
        }
        String _rows = request.getParameter("rows");
        Integer rows = 5 ;
        if(_rows!=null && !"".equals(_rows)){
            rows = Integer.parseInt(_rows);
        }
        //2. 调用业务层处理数据
        UserService userService = new UserServiceImpl();
        PageBean<User> pb = userService.findByPage(currentPage,rows);

        //3. 将查询数据保存到request域
        request.setAttribute("pb",pb);

        //4. 跳转页面
        request.getRequestDispatcher("/list_page.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
