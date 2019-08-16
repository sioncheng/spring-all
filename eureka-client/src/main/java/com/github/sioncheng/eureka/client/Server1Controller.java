package com.github.sioncheng.eureka.client;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/svr1")

public class Server1Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
