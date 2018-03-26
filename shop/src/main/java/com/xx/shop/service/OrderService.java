package com.xx.shop.service;

import com.xx.shop.ResultModel.ResultMap;

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

    ResultMap queryOrder(long orderId);
}
