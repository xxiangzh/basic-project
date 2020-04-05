package com.xzh.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动
 *
 * @author: 向振华
 * @date: 2019/10/11 10:56
 */
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.xzh.basic.dao.mapper")
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

}
