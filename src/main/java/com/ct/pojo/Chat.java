package com.ct.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_chat")
public class Chat {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    private String receiverId;
    private String sendId;
    private String message;
    private String conversationId;
    private String timeStamp;
}
