package com.ct.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.mapper.GoodsMapper;
import com.ct.pojo.Goods;
import com.ct.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Resource
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsService goodsService;

    @GetMapping()
    public BaseResponse<List<Goods>> getAllGoods() {
        List<Goods> goodsList = goodsService.getAllGoods();
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goodsList);
        return retMsg;
    }

    @GetMapping("/all")
    public Page<Goods> getAll(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String search
    ) {
        Page<Goods> goodsPage = goodsMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<Goods>lambdaQuery().like(Goods::getName, search));
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goodsPage);
        return goodsPage;
    }

    //通过类型id获取物品
    @GetMapping("cid/{id}")
    public BaseResponse<List<Goods>> getGoodsByCategoryId(@PathVariable("id") Integer id) {
        List<Goods> goodsList = goodsService.getGoodsByCategoryId(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goodsList);
        return retMsg;
    }

    //通过类型名称获取物品
    @GetMapping("cname/{name}")
    public BaseResponse<List<Goods>> getGoodsByCategoryName(@PathVariable String name) {
        List<Goods> goodsList = goodsService.getGoodsByCategoryName(name);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goodsList);
        return retMsg;
    }

}
