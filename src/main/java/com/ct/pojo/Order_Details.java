package com.ct.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Order_Details {
    //订单id
    private Integer orderid;
    //商品id
    private String goodsid;
    //数量
    private Integer num;
    //价格
    private Float price;
    //商品信息
    private Goods goods;

}
