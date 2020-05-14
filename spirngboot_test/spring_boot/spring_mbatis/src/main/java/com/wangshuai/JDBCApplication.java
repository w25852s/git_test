package com.wangshuai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wangshuai.dao")
public class JDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(JDBCApplication.class);
    }
}
