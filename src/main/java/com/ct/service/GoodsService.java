package com.ct.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ct.mapper.GoodsMapper;
import com.ct.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> getAllGoods(){
        return goodsMapper.selectList(null);
    }

    public List<Goods> getGoodsByCategoryId(int id){
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id",id);
        return goodsMapper.selectList(wrapper);
    }

}
