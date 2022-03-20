package com.ct.controller;


import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.pojo.Cart;
import com.ct.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userid}")
    public BaseResponse selectCartByUserId(@PathVariable("userid") String userid) {
        List<Cart> carts = this.cartService.selectCartByUserId(userid);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(carts);
        return retMsg;
    }

    @PostMapping("/{userid}")
    public BaseResponse insertCart(@PathVariable("userid") String userid,@RequestBody Cart cart) {
        cart.setUserid(userid);//下一步以登录的用户名为准
        this.cartService.insertCart(cart);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    @DeleteMapping("/{userid}/{goodsid}")
    public BaseResponse deleteCart(@PathVariable("userid") String userid, @PathVariable String goodsid) {
        Cart cart = new Cart();
        cart.setGoodsid(goodsid);
        cart.setUserid(userid);//下一步以登录的用户名为准
        this.cartService.deleteCart(cart);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    @PutMapping("/{userid}")
    public BaseResponse updateCart(@PathVariable("userid") String userid,@RequestBody Cart cart) {
        cart.setUserid(userid);//下一步以登录的用户名为准
        this.cartService.updateCart(cart);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

}
