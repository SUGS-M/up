package com.myy.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myy.user.entity.User;
import com.myy.user.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author SHData
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-07-30 14:02:51
* @Entity com.myy.up.entity.Users
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserVo> findby();
}




