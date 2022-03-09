package com.ct.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin")
public class Admin {
    private int sid;
    private int userId;
    @TableField("tb_user")
    private String name;
}
