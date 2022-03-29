package com.ct.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class Order {
    //订单id
    private Integer id;
    //用户id
    private String userid;
    //日期
    private String cdate;
    //订单状态
    private Integer status;
    //详细地址
    private String address;
    //电话
    private String phone;
    //快递单号
    private String expressid;
    //明细详情
    private List<Order_Details> detailsList;
}

