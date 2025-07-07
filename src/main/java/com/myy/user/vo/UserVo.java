package com.myy.user.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@TableName(value ="users")
@Data
public class UserVo implements Serializable {





    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}