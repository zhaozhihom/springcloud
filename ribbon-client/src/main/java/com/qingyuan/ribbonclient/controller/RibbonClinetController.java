package com.qingyuan.ribbonclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonClinetController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String client(){
        return restTemplate.getForObject("http://RIBBON-SERVER/", String.class);
    }

/*    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),   //
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),   //
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    },*/
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/test-hystrix/{number}")
    public String testHystrix(@PathVariable("number") Integer number) {
        if(number < 1)
           return restTemplate.getForObject("http://RIBBON-SERVER/", String.class);
        throw new RuntimeException("error");
    }

    public String fallback(Integer number){
        return "系统繁忙:" + number;
    }

}
