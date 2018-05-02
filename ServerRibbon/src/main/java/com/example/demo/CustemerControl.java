package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/2.
 */
@RestController
public class CustemerControl {

    @Autowired
    CustemerService service;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {//此处留于外部调用方法，但此方法添加了断路器
        return service.addService();

    }
}
