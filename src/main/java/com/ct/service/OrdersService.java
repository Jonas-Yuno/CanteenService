package com.ct.service;


import com.ct.mapper.CartMapper;
import com.ct.mapper.OrdersMapper;
import com.ct.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private CartMapper cartMapper;

    public List<Order> selectAllOrders(String userid) {
        List<Order> orders = this.ordersMapper.selectAllOrders(userid);
        return orders;
    }

    public Order selectOrderById(Integer id) {
        Order order = this.ordersMapper.selectOrderById(id);
        return order;
    }

    @Transactional   //开启事务，一旦发生异常，回滚。
    public void insertOrder(Order order) {
        this.ordersMapper.insertOrder(order);
        this.ordersMapper.insertOrderDetails(order);
        this.cartMapper.deleteAllCart(order.getUserid());
    }

    public void updateOrder(Order order) {
        this.ordersMapper.updateOrder(order);
    }

}
