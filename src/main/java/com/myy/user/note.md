主要功能
    用户注册/登录/当前用户/注销
    权限控制

主要库表
   [1]用户表
        id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
        username VARCHAR(50) NOT NULL UNIQUE COMMENT '账号',
        password VARCHAR(255) NOT NULL COMMENT '密码',
        dept_id VARCHAR(50) COMMENT '部门id',
        role TINYINT(1) NOT NULL DEFAULT 1 COMMENT '用户角色，0为管理员，1为普通用户',
        status TINYINT(1) NOT NULL DEFAULT 1 COMMENT '用户状态，1为启用，0为禁用',
        created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
        updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
        is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否删除，0为未删除，1为已删除'

主要配置
    server:
        port: 9090
    spring:
        application:
            name: up
    datasource:
        driver-class-name: com.mysql.jdbc.Driver
        password: 187369
        url: jdbc:mysql://localhost:3306/up?useUnicode=true&characterEncoding=UTF-8 
        username: root

        
