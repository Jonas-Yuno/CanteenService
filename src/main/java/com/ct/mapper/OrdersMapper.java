package com.ct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ct.pojo.Order;

import java.util.List;

public interface OrdersMapper extends BaseMapper<Order>{

    public List<Order> selectAllOrders(String userid);

    public Order selectOrderById(Integer id);

    public void insertOrder(Order order);

    public void insertOrderDetails(Order order);

    public void updateOrder(Order order);

}
