package com.itheima.web;

import com.itheima.service.DistrictService;
import com.itheima.service.impl.DistrictServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 一个servlet要能够接收多个不同的请求
 * /district/province
 * /district/city
 * /district/area
 * <p>
 * 完全路径匹配  /DistrictServlet
 * 目录匹配      /district/*     /district/province    /district/city    /district/area
 * 扩展名匹配     *.aaa    province.aaa  city.aaa  area.aaa
 */
@WebServlet("/district/*")
public class DistrictServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求地址
        String requestURI = request.getRequestURI();

        //1. 获取url的最后一部分 , 最后一部分就是我们需要的方法名称
        int index = requestURI.lastIndexOf("/");
        String mname = requestURI.substring(index + 1);
        //2. 根据方法名称动态获取导需要执行的方法对象 --- 反射
        try {
            //2.1 获取类的字节码对象
            Class clzz = this.getClass();
            //2.2 获取类中的方法
            Method method = clzz.getDeclaredMethod(mname, HttpServletRequest.class, HttpServletResponse.class);
            //2.3 让方法执行
            //暴力反射
            method.setAccessible(true);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 根据cid查询区域数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void area(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    /**
     * 查询所有用户数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void province(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    /**
     * 根据pid查询城市数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void city(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}
