package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Classname Config3344_App
 * @Description TODO
 * @Date 2019/9/28 17:41
 * @Created by Tengxq
 */
@SpringBootApplication
@EnableConfigServer
public class Config3344_App {
    public static void main(String[] args) {
        SpringApplication.run(Config3344_App.class,args);
    }
}
