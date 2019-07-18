package com.github.sioncheng.coffeeshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ac")
@RestController
public class AController {

    public AController(AA s) {
        System.out.println(s);
    }

    @RequestMapping("a")
    public String a() {
        return "a";
    }
}
