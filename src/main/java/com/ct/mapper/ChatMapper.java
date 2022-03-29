package com.ct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ct.pojo.Chat;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper extends BaseMapper<Chat> {
}
