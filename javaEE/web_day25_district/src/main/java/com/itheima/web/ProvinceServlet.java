package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Province;
import com.itheima.service.DistrictService;
import com.itheima.service.impl.DistrictServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/province")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //0.解决响应中文乱码
        response.setContentType("application/json;charset=utf-8");
        //1. 调用业务查询数据
        DistrictService districtService = new DistrictServiceImpl();
//        List<Province> provinces = districtService.findAllProvince();
//
//        //2. 将查询导的数据转化为json格式
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(provinces);

        String json = districtService.findAllProvinceJson();
        //3. 将json格式数据响应导客户端
        response.getWriter().write(json);
    }

    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }




}
