package com.springcloud.service;

import com.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT-8001")
public interface DeptClientService {

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping("/dept/list")
    public List<Dept> list();

    @RequestMapping("/dept/add")
    public boolean add(Dept dept);
}
