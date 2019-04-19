package com.itheima;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Car;
import com.itheima.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        List<Car> list = jdbcTemplate.query("select * from car", new BeanPropertyRowMapper<Car>(Car.class));
        response.setContentType("text/html;charset=utf-8");
        String json = new ObjectMapper().writeValueAsString(list);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
