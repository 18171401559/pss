package com.itheima.web;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 解决中文乱码
        request.setCharacterEncoding("UTF-8");
        //2. 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");

        //3. 进行验证码校验
        //3.1 获取session中保存的验证码
        String checkCode_session = (String) request.getSession().getAttribute("checkCode_session");
        if(verifycode==null || verifycode.equals("") || checkCode_session==null || checkCode_session.equals("") || !verifycode.equalsIgnoreCase(checkCode_session)){
            //验证码校验失败
            request.setAttribute("msg","验证码输入有误...");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        //4. 进行用户名密码校验
        UserService userService = new UserServiceImpl() ;
        User user = userService.login(username,password);//加入业务层有一个login方法,帮助我们完成登录操作
        //5. 根据情况进行页面跳转
        if(user==null){ //登录失败
            request.setAttribute("msg","用户名或密码有误...");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        //登录成功,保存用户信息
        request.getSession().setAttribute("loginedUser",user);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
