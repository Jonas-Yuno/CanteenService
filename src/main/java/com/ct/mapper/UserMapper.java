package com.ct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ct.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> selectAllUser();

//    @Select("SELECT * from tb_user a INNER JOIN admin b on a.id=b.user_id")
//    Page<Ustdvo> getPageVo(Page<Ustdvo> iPage);
}
