package com.itheima.dao;

import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.itheima.product.dao
 * @Author: PengSS
 * @Date: 2018/9/26 15:50
 */
public class ProductDao {
    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    public int findTotalCount() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        int count = queryRunner.query("select count(*) from user", new BeanHandler<Integer>(Integer.class));
        return count;
    }

    public List<ProductDao> findByPage(int start, int rows) {

        return null;
    }

    @Test
    public void findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //Long count = queryRunner.query("select count(*) from product");
        //System.out.println(count);
    }
}
