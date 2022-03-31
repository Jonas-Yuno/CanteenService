package com.ct.controller;

import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.pojo.User;
import com.ct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin   //允许跨域访问注解
@RestController//控制器各服务返回数据为字符串，如果return是对象或对象列表，Spring Boot自动转换成JSON给前端。
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public BaseResponse getAllUser() {
        return BaseResponse.success(userService.getAllUser());
    }

    //登录
    @PostMapping("/login")
    public BaseResponse login(@RequestBody User user) {
        User user1 = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        BaseResponse retMsg = new BaseResponse();
        if (user1 != null) {
            retMsg.setStatusCode(StatusCode.Success);
            retMsg.setData(user1);
            return retMsg;
        } else {
            retMsg.setStatusCode(StatusCode.Fail);
            retMsg.setMsg("账号或密码不正确");
            return retMsg;
        }
    }

    //登录
    @GetMapping("/login")
    public BaseResponse login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userService.getUserByEmailAndPassword(email, password);
        BaseResponse retMsg = new BaseResponse();
        if (user != null) {
            retMsg.setStatusCode(StatusCode.Success);
            retMsg.setData(user);
            return retMsg;
        } else {
            retMsg.setStatusCode(StatusCode.Fail);
            retMsg.setMsg("账号或密码不正确");
            return retMsg;
        }
    }

    @PostMapping("/register")
    public BaseResponse Logon(@RequestBody User user) {
        Integer row = userService.insertUser(user);
        BaseResponse retMsg = new BaseResponse();
        if (row != 0) {
            retMsg.setStatusCode(StatusCode.Success);
            retMsg.setData("注册成功");
            return retMsg;
        } else {
            retMsg.setStatusCode(StatusCode.Fail);
            retMsg.setData("注册失败");
            return retMsg;
        }
    }

    @GetMapping("/{id}")
    public BaseResponse<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(user);
        return retMsg;
    }

    //测试
    @GetMapping("/userid")
    public BaseResponse login(@RequestParam("id") int id) {
        User user = userService.getUserById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(user);
        return retMsg;
    }

}
