package com.myy.user.controller;

import com.myy.user.entity.User;
import com.myy.user.service.UserService;
import com.myy.user.vo.LoginUser;
import com.myy.user.vo.PasswordUpdateVo;
import com.myy.user.vo.RegisterUser;
import com.myy.user.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 用户中心
 */
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService usersService;
    public UserController(UserService usersService) {
        this.usersService = usersService;
    }
    //ToDo [1]微信登录/[2]手机登录/[3]邮箱登录

    /**
     * 注册
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUser registerUser){
        return ResponseEntity.ok(usersService.register(registerUser));
    }

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUser loginUser, HttpServletRequest request){
        return ResponseEntity.ok(usersService.login(loginUser,request));
    }
    /**
     * 获取用户信息
     */
    @GetMapping("/info")
    public ResponseEntity<User> getUserInfo(HttpServletRequest request){
        return ResponseEntity.ok(usersService.getUserInfo(request));
    }
    /**
     * 推出登录
     */
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        return ResponseEntity.ok(usersService.logout(request));
    }

    /**
     * 修改密码
     */
    @PostMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateVo passwordUpdateVo, HttpServletRequest request){
        return ResponseEntity.ok(usersService.updatePassword(passwordUpdateVo,request));
    }

}
