package com.myy.user.vo;


import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;


@Data
public class PasswordUpdateVo implements Serializable {




    /**
     * 原密码
     */
    @NonNull
    private String password;

    /**
     * 新密码
     */
    @NonNull
    private String newUsername;

    /**
     * 新校验密码
     */
    @NonNull
    private String newCheckUsername;




}