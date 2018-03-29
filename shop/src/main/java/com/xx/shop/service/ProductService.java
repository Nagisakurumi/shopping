package com.xx.shop.service;

import com.xx.shop.common.ProductDetail;
import com.xx.shop.dto.ProductPageDto;
import com.xx.shop.entity.Product;

import java.util.List;

public interface ProductService {

    ProductPageDto queryProList(int pageSize, int pageIndex, String order, boolean isAsc);

    List<Product> queryListByCate(int pageSize, int pageIndex, int cateId, String order, boolean isAsc);

    ProductDetail getDetail(long proId);
}
