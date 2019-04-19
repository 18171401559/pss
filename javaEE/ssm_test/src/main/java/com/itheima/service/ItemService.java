package com.itheima.service;

import com.itheima.domain.Items;

import java.util.List;

/**
 * @Package: com.itheima.service
 * @Author: PengSS
 * @Date: 2018/9/18 23:47
 */
public interface ItemService {
    List<Items> findAll();

    Items findById(int id);

    void update(Items items);
}
