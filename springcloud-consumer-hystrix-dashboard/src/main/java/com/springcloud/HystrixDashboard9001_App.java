package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Classname HystrixDashboard9001_App
 * @Description TODO
 * @Date 2019/9/28 16:01
 * @Created by Tengxq
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001_App {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001_App.class,args);
    }
}
