package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.City;
import com.itheima.service.DistrictService;
import com.itheima.service.impl.DistrictServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/city")
public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.解决响应中文乱码
        response.setContentType("application/json;charset=utf-8");
        //1. 接收参数  pid
        String pid = request.getParameter("pid");
        //2. 调用业务层查询数据 List<City>
        DistrictService districtService = new DistrictServiceImpl();
//        List<City> cities = districtService.findCityByPid(Integer.parseInt(pid));
//
//        //3. 将返回的数据转化为json格式
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(cities);
        String json = districtService.findCityJsonByPid(Integer.parseInt(pid));

        //4. 将json响应导客户端
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
