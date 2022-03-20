package com.ct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ct.pojo.Cart;

import java.util.List;

public interface CartMapper extends BaseMapper<Cart> {

    public List<Cart> selectCartByUserId(String userid);

    public void insertCart(Cart cart);

    public void deleteCart(Cart cart);

    public void deleteAllCart(String userid);

    public Cart selectCartByCart(Cart cart);

    public void updateCart(Cart cart);

}
