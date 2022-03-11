package com.ct.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {
    @TableId(value = "id", type = IdType.ASSIGN_UUID )
    private String id;
    private String username;
    private String password;
    private String nickname;
    private String image;
    private Integer roleId;
    private String roleName;
    private String sex;
    private String phone;
    private String email;

}
