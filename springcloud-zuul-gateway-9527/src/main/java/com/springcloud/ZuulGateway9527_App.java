package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Classname ZuulGateway9527_App
 * @Description TODO
 * @Date 2019/9/28 16:23
 * @Created by Tengxq
 */

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulGateway9527_App {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway9527_App.class,args);
    }
}
