package com.myy.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName users
 */
@TableName(value ="users")
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门id
     */
    private String dept_id;

    /**
     * 用户角色，0为管理员，1为普通用户
     */
    private Integer role;

    /**
     * 用户状态，1为启用，0为禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date created_time;

    /**
     * 更新时间
     */
    private Date updated_time;

    /**
     * 是否删除，0为未删除，1为已删除
     */
    private Integer is_deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}