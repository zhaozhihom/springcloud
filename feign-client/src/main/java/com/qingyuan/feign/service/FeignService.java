package com.qingyuan.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "RIBBON-SERVER", fallback = FeignService.RibbonServerFallback.class)
public interface FeignService {

    @RequestMapping("/")
    String hello();

    @Component
    static class RibbonServerFallback implements FeignService{
        @Override
        public String hello() {
            return "服务器开小差了~";
        }
    }

}
