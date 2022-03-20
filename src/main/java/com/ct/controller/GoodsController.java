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
@RequestMapping("goods/")
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

    @GetMapping("all")
    public BaseResponse<Page<Goods>> getAll(
            @RequestParam(defaultValue = "1") Integer pagenum,
            @RequestParam(defaultValue = "10") Integer pagesize,
            @RequestParam(defaultValue = "") String search
    ) {
        Page<Goods> goodsPage = goodsMapper.selectPage(new Page<>(pagenum, pagesize), Wrappers.<Goods>lambdaQuery().like(Goods::getName, search));
        BaseResponse<Page<Goods>> retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goodsPage);
        return retMsg;
    }

    //通过类型id获取物品
    @GetMapping("cid/{id}")
    public BaseResponse<List<Goods>> getGoodsByCategoryId(@PathVariable("id") Integer id) {
        List<Goods> goodsList = goodsService.getGoodsByCategoryId(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goodsList);
        return retMsg;
    }

    //通过类型名称分页获取物品
    @GetMapping("cname")
    public BaseResponse<Page<Goods>> getGoodsByCategoryName(
            @RequestParam(name = "pagenum",defaultValue = "1") Integer pagenum,
            @RequestParam(name = "pagesize",defaultValue = "10") Integer pagesize,
            @RequestParam(name = "name",defaultValue = "") String name
    ) {
        Page<Goods> goods = goodsService.getGoodsByCategoryName(new Page<>(pagenum, pagesize), name);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goods);
        return retMsg;
    }

}
