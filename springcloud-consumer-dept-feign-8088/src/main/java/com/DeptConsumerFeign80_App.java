package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.springcloud")
@Component("com.springcloud")
public class DeptConsumerFeign80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign80_App.class,args);
    }
}
