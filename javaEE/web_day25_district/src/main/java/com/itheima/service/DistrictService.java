package com.itheima.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.domain.Area;
import com.itheima.domain.City;
import com.itheima.domain.Province;

import java.util.List;

public interface DistrictService {
    /**
     * 查询所有省份数据
     * @return
     */
    List<Province> findAllProvince();

    /**
     * 查询所有省份数据
     * @return json
     */
    public String findAllProvinceJson() throws JsonProcessingException;

    /**
     * 根据省份id查询城市数据
     * @param pid
     * @return
     */
    List<City> findCityByPid(int pid);

    /**
     * 根据省份id查询城市数据
     * @param pid
     * @return  json
     */
    public String findCityJsonByPid(int pid) throws JsonProcessingException;

    /**
     * 根据城市id查询对应的区/县数据
     * @param cid
     * @return
     */
    List<Area> finAreaByCid(int cid);

    /**
     * 根据城市id查询对应的区/县数据
     * @param cid
     * @return
     */
    public String finAreaJsonByCid(int cid) throws JsonProcessingException;
}
