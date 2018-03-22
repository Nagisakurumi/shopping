package com.xx.shop.service;

import com.xx.shop.entity.ShopCart;

public interface CartService {
    ShopCart isExistPro(long proId, long userId);

    void InsertToCart(long storeId,long proId,long UserId);

    void UpdateToCart(ShopCart shopCart ,int i);
}
