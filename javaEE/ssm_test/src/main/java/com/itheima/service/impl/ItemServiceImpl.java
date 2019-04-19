package com.itheima.service.impl;

import com.itheima.dao.ItemDao;
import com.itheima.domain.Items;
import com.itheima.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package: com.itheima.service.impl
 * @Author: PengSS
 * @Date: 2018/9/18 23:47
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Items> findAll() {
        return itemDao.findAll();
    }

    @Override
    public Items findById(int id) {
        return itemDao.findById(id);
    }

    @Override
    public void update(Items items) {
        itemDao.update(items);
    }
}
