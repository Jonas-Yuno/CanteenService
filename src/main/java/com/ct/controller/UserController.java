package com.ct.controller;

import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.entity.User;
import com.ct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin   //允许跨域访问注解
@RestController  //控制器各服务返回数据为字符串，如果return是对象或对象列表，Spring Boot自动转换成JSON给前端。c
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public BaseResponse login(@RequestBody User user) {
        User user1 = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(user1);
        return retMsg;
    }

    @GetMapping("/login")
    public BaseResponse login(@RequestParam("id") int id) {
        User user1 = userService.getUserById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(user1);
        return retMsg;
    }

}
