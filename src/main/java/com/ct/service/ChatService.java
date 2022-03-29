package com.ct.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.mapper.ChatMapper;
import com.ct.mapper.ConversationMapper;
import com.ct.pojo.Chat;
import com.ct.pojo.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    private ConversationMapper conversationMapper;

    public BaseResponse getAllChatById(String receiverId, String sendId) {
        QueryWrapper<Conversation> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("receiver_id", receiverId).eq("send_id", sendId)
                .or().eq("receiver_id", sendId).eq("send_id", receiverId);
        Conversation conversation1 = conversationMapper.selectOne(wrapper1);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        if (conversation1 != null) {
            QueryWrapper<Chat> chatQueryWrapper = new QueryWrapper<>();
            chatQueryWrapper.eq("conversation_id", conversation1.getId());
            retMsg.setData(chatMapper.selectList(chatQueryWrapper));
            return retMsg;
        }else {
            retMsg.setCode(303); //无会话
            retMsg.setMsg("无会话");
            return retMsg;
        }
    }

    public BaseResponse getAllChatByConversationId(String conversationId) {
        QueryWrapper<Chat> wrapper = new QueryWrapper<>();
        wrapper.eq("conversation_id",conversationId);
        List<Chat> chatList = chatMapper.selectList(wrapper);
        if ( chatList.size() != 0) {
            return BaseResponse.success(chatList);
        } else
        {
            return BaseResponse.fail("无聊天记录");
        }
    }

    public void insertChat(Chat chat) {
        chatMapper.insert(chat);
    }
}
