package com.xx.shop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xx.shop.dao.ProductImagesMapper;
import com.xx.shop.dao.ProductMapper;
import com.xx.shop.entity.Product;
import com.xx.shop.entity.ProductExample;
import com.xx.shop.entity.ProductImages;
import com.xx.shop.entity.ProductImagesExample;
import com.xx.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductImagesMapper productImagesMapper;

    @Override
    public List<Product> queryProList(int pageSize, int pageIndex, String order,boolean isAsc) {
        PageHelper.startPage(pageIndex, pageSize);
        ProductExample productExample = new ProductExample();
        // productExample.getOredCriteria(order+  (isAsc ? "ASC" : "desc"));
        return productMapper.selectByExample(productExample);

    }

    @Override
    public List<Product> queryListByCate(int pageSize, int pageIndex, int cateId, String order, boolean isAsc) {
        PageHelper.startPage(pageIndex, pageSize);
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andCateEqualTo(cateId);
        //productExample.getOredCriteria(order+  (isAsc ? "ASC" : "desc"));
        return productMapper.selectByExample(productExample);
    }

    @Override
    public Product getDetail(long proId) {
//        ProductImagesExample productImagesExample =new ProductImagesExample();
//        ProductImagesExample.Criteria criteria = productImagesExample.createCriteria();
//        criteria.andPidEqualTo(proId);
//        productImagesMapper.selectByExample(productImagesExample);

        return productMapper.selectByPrimaryKey(proId);
    }

}
