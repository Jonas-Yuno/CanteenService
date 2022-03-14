package com.ct.service;

import com.ct.mapper.CategoryMapper;
import com.ct.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getAllCategory() {
        return categoryMapper.selectList(null);
    }

//    public String getCategoryIdByName(String name) {
//        return categoryMapper.select(null);
//    }
}
