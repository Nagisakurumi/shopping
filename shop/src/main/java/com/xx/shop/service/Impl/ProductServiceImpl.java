package com.xx.shop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.sun.tools.javac.util.Convert;
import com.xx.shop.common.ProductDetail;
import com.xx.shop.dao.ProductImagesMapper;
import com.xx.shop.dao.ProductMapper;
import com.xx.shop.dto.ProductPageDto;
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
    public ProductPageDto queryProList(int pageSize, int pageIndex, String order, boolean isAsc) {
        ProductExample productExample = new ProductExample();
        productExample.setOrderByClause(order+" "+(isAsc ? "ASC" : "desc"));
        int totalPage =(int)productMapper.countByExample(productExample);
        PageHelper.startPage(pageIndex, pageSize);

        List<Product> product =productMapper.selectByExample(productExample);
        ProductPageDto productPageDtoList = new ProductPageDto();

        productPageDtoList.setProductList(product);
        productPageDtoList.setTotalPage(totalPage);
        return productPageDtoList;

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
    public ProductDetail getDetail(long proId) {
//        ProductImagesExample productImagesExample =new ProductImagesExample();
//        ProductImagesExample.Criteria criteria = productImagesExample.createCriteria();
//        criteria.andPidEqualTo(proId);
//        productImagesMapper.selectByExample(productImagesExample);
        Product product = productMapper.selectByPrimaryKey(proId);
        ProductImagesExample productImagesExample = new ProductImagesExample();
        ProductImagesExample.Criteria criteria = productImagesExample.createCriteria();
        criteria.andPidEqualTo(proId);
        List<ProductImages> productImages = productImagesMapper.selectByExample(productImagesExample);
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setProductImages(productImages);
        return  productDetail;
    }

}
