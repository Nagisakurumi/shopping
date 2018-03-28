package com.xx.shop.service.Impl;

import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.dao.OrderMapper;
import com.xx.shop.entity.Order;
import com.xx.shop.entity.OrderDetail;
import com.xx.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResultMap addOneOrder() {
        return null;
    }

    @Override
    public ResultMap deleteOrder(long orderId) {
        return null;
    }

    @Override
    public ResultMap completeOrder(long orderId) {
        return null;
    }

    @Override
    public Order queryOrderByOrderId(long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<OrderDetail> queryOrderByUserId(long userId) {
        return null;
    }
}
