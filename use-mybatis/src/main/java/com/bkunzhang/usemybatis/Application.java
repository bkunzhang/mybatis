package com.bkunzhang.usemybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bkunzhang
 * @date 2019/10/15
 */
@SpringBootApplication
@MapperScan("com.bkunzhang.usemybatis.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
