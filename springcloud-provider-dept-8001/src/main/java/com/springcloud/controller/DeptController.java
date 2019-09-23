package com.springcloud.controller;

import com.springcloud.entity.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GongXings
 * @createTime 30 15:07
 * @description
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept Dept) {
        return   deptService.addDept(Dept);
    }
    @RequestMapping(value = "/dept/get/{deptNo}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("deptNo") Long deptNo) {
        return  deptService.findById(deptNo);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll() {
        return deptService.findAll();
    }



}