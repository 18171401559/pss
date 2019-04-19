package com.itheima.inter;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;

/**
 * @Package: com.itheima.inter
 * @Author: PengSS
 * @Date: 2018/10/26 10:01
 */
public interface RowMapper {
    Object mapRow(ResultSet rs);
}
