package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ConfigTestController
 * @Description TODO
 * @Date 2019/9/28 18:44
 * @Created by Tengxq
 */
@RestController
public class ConfigTestController {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){

        System.out.println("applicationName:"+this.applicationName
                +"defaultZone"+this.eurekaServers
                +"port:"+this.port);
        return "applicationName:"+this.applicationName
                +"defaultZone"+this.eurekaServers
                +"port:"+this.port;
    }
}
