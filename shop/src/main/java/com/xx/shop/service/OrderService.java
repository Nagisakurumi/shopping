package com.xx.shop.service;

import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.entity.Order;
import com.xx.shop.entity.OrderDetail;
import com.xx.shop.entity.Store;

import java.util.List;

public interface OrderService {

    ResultMap addOneOrder();

    /**
     * 删除一个订单
     * @param orderId
     * @return
     */
    ResultMap deleteOrder(long orderId);

    /**
     * 完成一个订单
     * @param orderId
     * @return
     */
    ResultMap completeOrder(long orderId);

    /**
     * 查询订单
     * @param orderId
     * @return
     */
    Order queryOrderByOrderId(long orderId);

    /**
     * 根据用户id查询订单
     * @param userId
     * @return
     */
    List<OrderDetail> queryOrderByUserId(long userId);
}
