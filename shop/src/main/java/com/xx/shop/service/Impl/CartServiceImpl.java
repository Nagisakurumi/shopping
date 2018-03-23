package com.xx.shop.service.Impl;

import com.xx.shop.dao.ShopCartMapper;
import com.xx.shop.entity.ShopCart;
import com.xx.shop.entity.ShopCartExample;
import com.xx.shop.service.CartService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    ShopCartMapper shopCartMapper;
    @Override
    public ShopCart isExistPro(long proId, long userId) {
        ShopCartExample shopCartExample = new ShopCartExample();
        ShopCartExample.Criteria criteria =shopCartExample.createCriteria();
        criteria.andProductIdEqualTo(proId);
        criteria.andUserIdEqualTo(userId);
        List<ShopCart> cartList =shopCartMapper.selectByExample((shopCartExample));
        int count = cartList.size();
        if(count == 1){
            for (ShopCart shopCart:cartList
                 ) {
                return shopCart;
            }
        }else if(count>1){
            shopCartMapper.deleteByExample(shopCartExample);
            return null;
        }else{
            return null;
        }
        return null;
    }

    @Override
    public void InsertToCart(long storeId,long proId,long userId) {
        ShopCart shopCart = new ShopCart();
        shopCart.setUserId(userId);
        shopCart.setCreateTime(new Date());
        shopCart.setNum(1);
        shopCart.setProductId(proId);
        shopCart.setStoreId(storeId);
        shopCart.setUpdateTime(new Date());
        shopCartMapper.insert(shopCart);
    }

    @Override
    public void UpdateToCart(ShopCart shopCart, int i) {
        shopCart.setNum(shopCart.getNum()+1);
        shopCartMapper.updateByPrimaryKey(shopCart);
    }
}
