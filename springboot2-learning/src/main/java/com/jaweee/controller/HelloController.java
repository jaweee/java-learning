package com.jaweee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping("/list")
    public String sayHello(@RequestParam("name") String name){
        return "hello welcome springboot2's wolrd" + name;
    }
}
