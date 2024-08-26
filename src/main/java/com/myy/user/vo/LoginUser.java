package com.myy.user.vo;


import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;



@Data
public class LoginUser implements Serializable {


    /**
     * 账号
     */
    @NonNull
    private String username;

    /**
     * 密码
     */
    @NonNull
    private String password;




}