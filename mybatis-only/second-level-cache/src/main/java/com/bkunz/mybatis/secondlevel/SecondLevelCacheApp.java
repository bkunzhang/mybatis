package com.bkunz.mybatis.secondlevel;

import com.bkunz.mybatis.secondlevel.model.RequireBillLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/secondLevelCache")
public class SecondLevelCacheApp {
    @Autowired
    private SecondLevelCacheService secondLevelCacheService;

    @RequestMapping("/{id}")
    public RequireBillLog getLog(@PathVariable int id) {
        return secondLevelCacheService.getLog(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(SecondLevelCacheApp.class, args);
    }
}
