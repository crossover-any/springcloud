package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.entity.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tengxq
 * @createTime 30 15:07
 * @description
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept Dept) {
        return   deptService.addDept(Dept);
    }

    @RequestMapping(value = "/dept/get/{deptNo}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept findById(@PathVariable("deptNo") Long deptNo) {
        Dept dept = deptService.findById(deptNo);
        if (null ==dept){
            throw new RuntimeException("该ID:"+deptNo+"没有与之对应的信息");
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    @RequestMapping("/dept/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("**************"+list);

        List<ServiceInstance> srvList = client.getInstances("provider-dept-8001");
        for (ServiceInstance element : srvList){
            System.out.println(element.getServiceId()+"\t"+ element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.client;
    }

    public Dept processHystrix_Get(@PathVariable("deptNo")Long id){
        return new Dept().setDname("没有与该ID:"+id+"对应的信息---@HystrixCommand").setDbSource("no this database in MySQL").setDeptno(id);
    }

}