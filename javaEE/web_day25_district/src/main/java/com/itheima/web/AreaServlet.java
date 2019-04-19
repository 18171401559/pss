package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Area;
import com.itheima.service.DistrictService;
import com.itheima.service.impl.DistrictServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/area")
public class AreaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.解决响应中文乱码
        response.setContentType("application/json;charset=utf-8");
        //1. 获取参数 cid
        String cid = request.getParameter("cid");
        //2. 调用业务层查询数据
        DistrictService districtService = new DistrictServiceImpl();
//        List<Area> areas =   districtService.finAreaByCid(Integer.parseInt(cid));
//
//        //3. 将返回的数据转化为json
//        //4. 将json数据响应导客户端
//        ObjectMapper mapper = new ObjectMapper();
        String json = districtService.finAreaJsonByCid(Integer.parseInt(cid));
        //mapper.writeValue(response.getWriter(),areas);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
