package com.ct.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_category")
public class Category {
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;
    private String cname;
}
