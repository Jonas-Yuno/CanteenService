package com.ct.controller;

import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.pojo.Category;
import com.ct.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public BaseResponse<List<Category>> getAllCategory(){
        List<Category> categoryList = categoryService.getAllCategory();
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(categoryList);
        return retMsg;
    }

}
