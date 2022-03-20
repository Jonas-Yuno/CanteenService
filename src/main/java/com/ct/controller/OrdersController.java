package com.ct.controller;


import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.pojo.Order;
import com.ct.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping()
    public BaseResponse selectAllOrders(@RequestParam("userid") String userid) {
        List<Order> orders = this.ordersService.selectAllOrders(userid);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(orders);
        return retMsg;
    }

    @GetMapping("{id}")
    public BaseResponse selectOrderById(@PathVariable Integer id) {
        Order order = this.ordersService.selectOrderById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(order);
        return retMsg;
    }

    @PostMapping
    public BaseResponse insertOrder(@RequestBody Order order) {
//        order.setUserid("user1");//下一步以登录的用户名为准
        this.ordersService.insertOrder(order);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    @PutMapping
    public BaseResponse updateOrder(@RequestBody Order order) {
        this.ordersService.updateOrder(order);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

}
