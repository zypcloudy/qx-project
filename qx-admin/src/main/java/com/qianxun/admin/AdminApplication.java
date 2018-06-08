package com.qianxun.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//让swagger扫描到controller
@ComponentScan(basePackages = "com.qianxun")
//扫描到子模块下面的bean
@MapperScan("com.qianxun.admin.dao")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}