package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/5/2.
 */
@Service
public class CustemerService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "dealError")//定义如下服务发生异常将要调用的方法
    public String registerCallBack() {
        return restTemplate.getForEntity("http://EUREKA-CLIENT-HI/add?a=10&b=20", String.class).getBody();
    }

    public String dealError() {
        return "dealError";
    }


    /**addService方法将留于外部地哦啊用，当addService方法出现异常时，为了不影响分布式服务，将会返回一个默认值,同时终止掉此异常服务**/
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://EUREKA-CLIENT-HI/add?a=10&b=20", String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }

}
