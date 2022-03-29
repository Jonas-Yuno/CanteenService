package com.ct.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ct.api.BaseResponse;
import com.ct.mapper.ConversationMapper;
import com.ct.pojo.Chat;
import com.ct.pojo.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {

    @Autowired
    private ConversationMapper conversationMapper;

    public List<Conversation> getAllConversations(){
        return conversationMapper.selectList(null);
    }

    //新建一个会话
    public BaseResponse insertConversion(Conversation conversation){
        conversationMapper.insert(conversation);
        return BaseResponse.success(conversation.getId());
    }
}
