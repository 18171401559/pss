package com.itheima.web;

import com.itheima.domian.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Package: ${PACKAGE_NAME}
 * @Author: PengSS
 * @Date: 2018/9/26 14:59
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkImg = (String) request.getSession().getAttribute("checkImg");
        String checkStr = request.getParameter("checkStr");
        if (!checkImg.equalsIgnoreCase(checkStr)) {
            request.setAttribute("msg", "验证码不正确");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        UserService userService = new UserService();
        try {
            User u = userService.login(user);
            if (u == null) {
                request.setAttribute("msg", "用户名或者密码错误");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("user", u.getUsername());
                response.sendRedirect("/index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
