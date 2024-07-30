package com.myy.up.Service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myy.up.Entity.Users;
import com.myy.up.Vo.UsersVo;
import com.myy.up.Mapper.UsersMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author SHData
* @description 针对表【users】的数据库操作Service
* @createDate 2024-07-30 14:02:51
*/
@Service
public class UsersService extends ServiceImpl<UsersMapper, Users> {

    public List<UsersVo> findBy() {
        return baseMapper.findby();
    }
}


