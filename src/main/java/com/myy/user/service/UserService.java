package com.myy.user.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myy.user.entity.User;
import com.myy.user.vo.LoginUser;
import com.myy.user.mapper.UserMapper;
import com.myy.user.vo.PasswordUpdateVo;
import com.myy.user.vo.RegisterUser;
import com.myy.user.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import static com.myy.user.constant.UserConstant.USER_LOGIN_STATE;

/**
* @author SHData
* @description 针对表【users】的数据库操作Service
* @createDate 2024-07-30 14:02:51
*/
@Service
public class UserService extends ServiceImpl<UserMapper, User> {


    /**
     * 注册
     */
    public String register(RegisterUser registerUser) {
        //1.验证参数
        if (StrUtil.isBlank(registerUser.getUsername()) || StrUtil.isBlank(registerUser.getPassword()) || StrUtil.isBlank(registerUser.getCheckPassword())) {
            return "参数不能为空";
        }
        if(registerUser.getPassword().length() < 6 || registerUser.getCheckPassword().length() < 6){
            return "密码长度不能小于6";
        }
        if(!registerUser.getPassword().equals(registerUser.getCheckPassword())){
            return "两次密码不一致";
        }
        synchronized (registerUser.getUsername().intern() ){
            //2.验证用户名是否存在
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", registerUser.getUsername());
            User user = this.getOne(queryWrapper);
            if (user != null) {
                return "用户名已存在";
            }
            //3.密码加密
            //4.保存用户信息
            User newUser = new User();
            newUser.setUsername(registerUser.getUsername());
            newUser.setPassword(registerUser.getPassword());
            int userid = baseMapper.insert (newUser);
            if (userid == 0) {
                return "注册失败";
            }
            return "注册成功";
        }
    }


    /**
     *登录
     */
    public String login(LoginUser loginUser, HttpServletRequest request) {
        // 1.参数校验
        if (StrUtil.isBlank(loginUser.getUsername()) || StrUtil.isBlank(loginUser.getPassword())) {
            return "参数不能为空";
        }
        if (loginUser.getPassword().length() < 6) {
            return "密码错误";
        }
        // 2.查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginUser.getUsername());
        queryWrapper.eq("password", loginUser.getPassword());
        User user = this.getOne(queryWrapper);
        if (user == null) {
            return "不存在当前用户,请检查用户名或密码";
        }
        // 3.将用户信息保存到session中
        request.getSession().setAttribute(USER_LOGIN_STATE, user);
        // 4.返回登录成功
        return "登录成功";
    }


    /**
     * 获取用户信息
     * @param request
     * @return
     */
    public User getUserInfo(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if (user == null) {
            return null;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", user.getId());
        User userVo = baseMapper.selectOne(queryWrapper);
        return userVo;
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(USER_LOGIN_STATE);
        return "退出成功";
    }

    public String updatePassword(PasswordUpdateVo passwordUpdateVo, HttpServletRequest request) {
        //1.是否登录校验
        //ToDO 步骤1中，登录状态，更新为[短信/邮箱]的验证码完成验证
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if (user == null) {
            return "用户未登录";
        }
        //2.用户定位
        //3.校验旧密码是否正确，新密码是否符合标准
        //4.修改密码
//        User user1 = BeanUtil.copyProperties(userVo, User.class);
//        if (result > 0) {
//            request.getSession().removeAttribute(USER_LOGIN_STATE);
//            return "修改成功";
//        } else {
//            return "修改失败";
//        }
        return "接口待开发";
    }
}


