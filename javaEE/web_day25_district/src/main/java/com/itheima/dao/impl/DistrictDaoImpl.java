package com.itheima.dao.impl;

import com.itheima.dao.DistrictDao;
import com.itheima.domain.Area;
import com.itheima.domain.City;
import com.itheima.domain.Province;
import com.itheima.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DistrictDaoImpl implements DistrictDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<Province> findAllProvince() {
        String sql = "select * from province";
        List<Province> provinces = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return provinces;
    }

    @Override
    public List<City> findCityByPid(int pid) {
        String sql = "select * from city where pid = ? ";
        List<City> cities = jdbcTemplate.query(sql, new BeanPropertyRowMapper<City>(City.class), pid);
        return cities;
    }

    @Override
    public List<Area> finAreaByCid(int cid) {
        String sql = "select * from area where cid = ? ";
        List<Area> areas = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Area>(Area.class), cid);
        return areas;

    }
}
