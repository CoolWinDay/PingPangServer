package com.pingpang.grade.controller;

import com.pingpang.grade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    String index() {
        return "Hello Spring Boot";
    }

    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }

    @Autowired
    private UserService userService;

//    @RequestMapping("/showUser/{id}")
//    public String selectUser (@PathVariable int id){
//        return userService.selectUser(id).toString();
//
//    }
}
