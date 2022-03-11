package com.ct.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_category")
public class Category {
    private int cId;
    private String cName;
}
