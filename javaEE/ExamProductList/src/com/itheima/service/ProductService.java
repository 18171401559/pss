package com.itheima.service;

import com.itheima.dao.ProductDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @Package: com.itheima.service
 * @Author: PengSS
 * @Date: 2018/9/26 15:46
 */
public class ProductService {
    private ProductDao  productDao = new ProductDao();
    public PageBean<Product> findProductByPage(String _currentPage, String _rows) throws SQLException {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<Product> pb = new PageBean<Product>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询总记录数
        int totalCount = productDao.findTotalCount();
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<ProductDao> list = productDao.findByPage(start,rows);
        //pb.setList(list);

        //5.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
