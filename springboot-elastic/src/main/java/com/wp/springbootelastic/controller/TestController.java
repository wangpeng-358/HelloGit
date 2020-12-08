package com.wp.springbootelastic.controller;

import com.wp.springbootelastic.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("testGet")
    public void hello(){
        testService.hello();
    }


}
