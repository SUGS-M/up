package com.myy.up.Vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName users
 */
@TableName(value ="users")
@Data
public class UsersVo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @ExcelProperty(index = 0)
    private String username;

    /**
     * 
     */
    @ExcelProperty(index = 1)
    private String password;

    /**
     * 
     */
    private String email;




    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}