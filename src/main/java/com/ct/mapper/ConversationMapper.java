package com.ct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ct.pojo.Conversation;
import org.apache.ibatis.annotations.Update;

public interface ConversationMapper extends BaseMapper<Conversation> {
    @Update("update t_conversation set last_message=#{message} where id=#{conversationId}")
    Integer updateLastMessage(String conversationId ,String message);
}
