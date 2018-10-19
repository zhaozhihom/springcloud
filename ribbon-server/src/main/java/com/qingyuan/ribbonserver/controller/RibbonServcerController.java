package com.qingyuan.ribbonserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonServcerController {

    @Value("${server.port}")
    private String port;

    @GetMapping("")
    public String ribbon(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

}
