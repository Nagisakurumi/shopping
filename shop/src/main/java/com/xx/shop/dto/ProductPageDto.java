package com.xx.shop.dto;

import com.xx.shop.entity.Product;

import java.util.List;

public class ProductPageDto {
    private List<Product> productList;
    private int totalPage;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
