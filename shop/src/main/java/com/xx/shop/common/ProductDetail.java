package com.xx.shop.common;

import com.xx.shop.entity.Product;
import com.xx.shop.entity.ProductImages;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class ProductDetail {

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ProductImages> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImages> productImages) {
        this.productImages = productImages;
    }

    private List<ProductImages> productImages;



}
