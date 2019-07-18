package com.github.sioncheng.mvc;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class AController {

    @RequestMapping("a1")
    public String a1() {
        return "a1";
    }
}
