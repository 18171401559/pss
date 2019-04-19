package com.itheima.web;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Package: ${PACKAGE_NAME}
 * @Author: PengSS
 * @Date: 2018/9/26 15:44
 */
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        //2.调用service查询
        ProductService service = new ProductService();
        PageBean<Product> pb = null;
        try {
            pb = service.findProductByPage(currentPage, rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3.将PageBean存入request
        request.setAttribute("pb", pb);
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
