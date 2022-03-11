package com.ct.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.pojo.Goods;
import com.ct.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("all")
    public BaseResponse<List<Goods>> getAllGoods(){
        List<Goods> goodsList = goodsService.getAllGoods();
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goodsList);
        return retMsg;
    }

    @GetMapping("category/{id}")
    public BaseResponse<List<Goods>> getGoodsByCategoryId(@PathVariable int id){
        List<Goods> goodsList = goodsService.getGoodsByCategoryId(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goodsList);
        return retMsg;
    }

}
