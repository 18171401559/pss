package com.itheima.dao;

import com.itheima.domain.Area;
import com.itheima.domain.City;
import com.itheima.domain.Province;

import java.util.List;

public interface DistrictDao {

    /**
     * 查询所有省份数据
     * @return
     */
    List<Province> findAllProvince();

    /**
     * 根据pid查询城市
     * @param pid
     * @return
     */
    List<City> findCityByPid(int pid);

    /**
     * 根据城市id查询区域
     * @param cid
     * @return
     */
    List<Area> finAreaByCid(int cid);
}
