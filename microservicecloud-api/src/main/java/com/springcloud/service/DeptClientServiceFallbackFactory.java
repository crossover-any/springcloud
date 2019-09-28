package com.springcloud.service;

import com.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname DeptClientServiceFallbackFactory
 * @Description TODO
 * @Date 2019/9/28 11:37
 * @Created by Tengxq
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return new Dept().setDname("没有与该ID:"+id+"对应的信息---@HystrixCommand").setDbSource("no this database in MySQL").setDeptno(id);
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
