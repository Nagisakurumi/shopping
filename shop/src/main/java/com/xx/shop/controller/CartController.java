package com.xx.shop.controller;

import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.common.SessionHelper;
import com.xx.shop.dto.SessionUser;
import com.xx.shop.entity.Product;
import com.xx.shop.entity.ShopCart;
import com.xx.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    public CartService cartService;

    public ResultMap AddToCart(Long storeId, long proId, HttpSession session){
        SessionUser sessionUser = SessionHelper.getUserSession(SessionHelper.userInfo,session);
        if(sessionUser==null){
            return ResultMap.getErrorResultMap("NOLOGIN");
        }else{
            ShopCart shopCart = cartService.isExistPro(proId,sessionUser.getUserId());
            //已存在产品
            if(shopCart==null){
                cartService.InsertToCart(storeId,proId,sessionUser.getUserId());
            }else{//不存在产品
                cartService.UpdateToCart(shopCart,1);
            }
        }

        return ResultMap.getResultMap("");

    }
}
