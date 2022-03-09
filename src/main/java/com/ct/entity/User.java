package com.ct.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private Integer roleId;
    private String roleName;
    private String sex;
    private String phone;
    private String email;
}
