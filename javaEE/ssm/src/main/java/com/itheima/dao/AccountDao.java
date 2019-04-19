package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.itheima.dao
 * @Author: PengSS
 * @Date: 2018/9/16 14:30
 */
@Repository
public interface AccountDao {

    @Select("select * from account")
    List<Account> findAll();
}
