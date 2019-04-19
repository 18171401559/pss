package com.itheima.dao;

import com.itheima.domain.Items;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: com.itheima.dao
 * @Author: PengSS
 * @Date: 2018/9/18 23:49
 */
@Repository
public interface ItemDao {

    @Select("select * from items")
    List<Items> findAll();

    @Select("select * from items where id = #{id}")
    Items findById(int id);

    @Update("update items set name = #{name},price=#{price},createtime=#{createtime},pic=#{pic},detail=#{detail} where id =#{id}")
    void update(Items items);
}
