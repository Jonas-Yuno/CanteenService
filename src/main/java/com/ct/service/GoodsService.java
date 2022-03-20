package com.ct.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ct.mapper.GoodsMapper;
import com.ct.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PrimitiveIterator;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> getAllGoods() {
        return goodsMapper.selectList(null);
    }

    //通过类型id获取物品
    public List<Goods> getGoodsByCategoryId(Integer id) {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id", id);
        return goodsMapper.selectList(wrapper);
    }

    //通过类型名称获取物品
    public Page<Goods> getGoodsByCategoryName(Page page, String categoryName) {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.inSql("category_id", "select cid from tb_category where cname = " + "'" + categoryName + "'");
        Page<Goods> pageGoods = goodsMapper.selectPage(page, wrapper);
        return pageGoods;
    }

}
