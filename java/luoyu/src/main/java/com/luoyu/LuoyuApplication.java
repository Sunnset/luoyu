package com.luoyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luoyu.*.mapper")
public class LuoyuApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuoyuApplication.class, args);
    }

}