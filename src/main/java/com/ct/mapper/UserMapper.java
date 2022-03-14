package com.ct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ct.pojo.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectAllUser();
    List<User> selectAll(Page<User> page);

//    @Select("SELECT * from tb_user a INNER JOIN admin b on a.id=b.user_id")
//    Page<Ustdvo> getPageVo(Page<Ustdvo> iPage);
}
