package com.luoyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.luoyu.dao.mapper"})
public class LuoyuWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuoyuWebApplication.class, args);
    }


}
