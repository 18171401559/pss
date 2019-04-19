package com.itheima.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.dao.DistrictDao;
import com.itheima.dao.impl.DistrictDaoImpl;
import com.itheima.domain.Area;
import com.itheima.domain.City;
import com.itheima.domain.Province;
import com.itheima.service.DistrictService;
import com.itheima.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class DistrictServiceImpl implements DistrictService {

    private DistrictDao districtDao = new DistrictDaoImpl();
    @Override
    public List<Province> findAllProvince() {

        return districtDao.findAllProvince();
    }

    /**
     * province
     * 使用jedis优化查询省份数据的操作
     * @return
     */
    @Override
    public String findAllProvinceJson() throws JsonProcessingException {
        //1. 先从redis中获取数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String json = jedis.get("province");
        if(json!=null && json.length()>0){
            System.out.println("缓存中有数据....");
            //2. 获取到数据,直接返回
            return json ;
        }

        //3. 获取不到数据  从数据库查询数据,存入导redis之中
        List<Province> provinces = districtDao.findAllProvince();
        //3.1 将数据转化为json保存在redis之中
        ObjectMapper mapper = new ObjectMapper();
        json = mapper.writeValueAsString(provinces);
        //3.2 将json保存在redis
        jedis.set("province",json);
        System.out.println("缓存中没有数据,查询数据库....");
        return json ;
    }

    @Override
    public List<City> findCityByPid(int pid) {

        return districtDao.findCityByPid(pid);
    }

    /**
     * province_city_2
     * @param pid
     * @return
     */
    @Override
    public String findCityJsonByPid(int pid) throws JsonProcessingException {
        //1. 先从redis中获取数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String json = jedis.get("province_city_"+pid);
        if(json!=null && json.length()>0){
            System.out.println("查询城市数据----缓存中有数据....");
            //2. 获取到数据,直接返回
            return json ;
        }

        //3. 获取不到数据  从数据库查询数据,存入导redis之中
        List<City> cities = districtDao.findCityByPid(pid);
        //3.1 将数据转化为json保存在redis之中
        ObjectMapper mapper = new ObjectMapper();
        json = mapper.writeValueAsString(cities);
        //3.2 将json保存在redis
        jedis.set("province_city_"+pid,json);
        System.out.println("查询城市数据----缓存中没有数据,查询数据库....");

        return json;
    }

    @Override
    public List<Area> finAreaByCid(int cid) {
        return districtDao.finAreaByCid(cid);
    }

    /**
     * city_area_cid
     * @param cid
     * @return
     */
    @Override
    public String finAreaJsonByCid(int cid) throws JsonProcessingException {
        //1. 先从redis中获取数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String json = jedis.get("city_area_"+cid);
        if(json!=null && json.length()>0){
            System.out.println("查询区/县数据----缓存中有数据....");
            //2. 获取到数据,直接返回
            return json ;
        }

        //3. 获取不到数据  从数据库查询数据,存入导redis之中
        List<Area> areas = districtDao.finAreaByCid(cid);
        //3.1 将数据转化为json保存在redis之中
        ObjectMapper mapper = new ObjectMapper();
        json = mapper.writeValueAsString(areas);
        //3.2 将json保存在redis
        jedis.set("city_area_"+cid,json);
        System.out.println("查询区/县数据----缓存中没有数据,查询数据库....");

        return json;
    }
}
