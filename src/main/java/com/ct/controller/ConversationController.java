package com.ct.controller;

import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.pojo.Chat;
import com.ct.pojo.Conversation;
import com.ct.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("conversation")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping
    public BaseResponse getAllConversations(){
        List<Conversation> conversationList = conversationService.getAllConversations();
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(conversationList);
        return retMsg;
    }

    //新建一个会话
    @PostMapping
    public BaseResponse insertConversions(@RequestBody Conversation conversation){
        return conversationService.insertConversion(conversation);
    }

//    @GetMapping("/{receiverid}/{sendid}")
//    public BaseResponse getConversationsById(@PathVariable("receiverid") String receiverId, @PathVariable("sendid") String sendId){
//        List<Conversation> conversationList = conversationService.getAllConversations();
//        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
//        retMsg.setData(conversationList);
//        return retMsg;
//    }
}
