package com.itheima.web;

import com.itheima.domain.PageBean;
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

@WebServlet("/search")
public class SearchByPageServlet extends HttpServlet {
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

        //接收用户搜索参数
        Map<String, String[]> map = request.getParameterMap();
        //封装用户数据进对象,作为搜索条件
        User condition = new User();
        try {
            BeanUtils.populate(condition,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2. 调用业务层处理数据
        UserService userService = new UserServiceImpl();
        PageBean<User> pb = userService.findByPage(currentPage,rows,condition);

        //3. 将查询数据保存到request域
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);

        //4. 跳转页面
        request.getRequestDispatcher("/list_search.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
