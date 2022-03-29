package com.ct.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_conversation")
public class Conversation {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    private String lastMessage;
    private String receiverId;
    private String receiverName;
    private String receiverImage;
    private String sendId;
    private String sendName;
    private String sendImage;
    private String timeStamp;
}
