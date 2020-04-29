package com.hr.springboot;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.hr.springboot.mapper")
public class SpringbootShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiroApplication.class, args);
    }

}
