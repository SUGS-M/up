package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Users;
import generator.service.UsersService;
import generator.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author SHData
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-07-30 15:00:05
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




