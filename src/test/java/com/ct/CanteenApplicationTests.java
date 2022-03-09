package com.ct;



import com.ct.entity.User;
import com.ct.mapper.UserMapper;
import com.ct.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CanteenApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectByName() {
        System.out.println(("----- selectAll method test ------"));
        //User user = userService.getUserByEmailAndPassword("admin@qq.com", "123456");
//        List<User> users = userService.getAllUser();
//        System.out.println(users.toString());
        //Page<Ustdvo> iPage = new Page<Ustdvo>(1, 1);
       // userMapper.getPageVo(iPage);
//        if (user != null)
//        {
//            System.out.println("有该用户可以登录！");
//        }else
//        {
//            System.out.println("该用户不可以登录！");
//        }
    }

}
