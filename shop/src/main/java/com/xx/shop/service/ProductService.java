package com.xx.shop.service;

import com.xx.shop.dto.ProDetail;
import com.xx.shop.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> queryProList(int pageSize, int pageIndex, String order, boolean isAsc);

    List<Product> queryListByCate(int pageSize, int pageIndex, int cateId, String order, boolean isAsc);

    Product getDetail(long proId);
}
