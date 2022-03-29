package com.ct.controller;


import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.pojo.Category;
import com.ct.pojo.Chat;
import com.ct.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/{receiverid}/{sendid}")
    public BaseResponse getAllChatById(@PathVariable("receiverid") String receiverId, @PathVariable("sendid") String sendId) {
        return chatService.getAllChatById(receiverId,sendId);
    }

    @GetMapping("/{conversationId}")
    public BaseResponse getAllChatByConversationId(@PathVariable("conversationId")String conversationId) {
        return chatService.getAllChatByConversationId(conversationId);
    }

    @PostMapping
    public BaseResponse insertChat(@RequestBody Chat chat) {
        chatService.insertChat(chat);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }
}
