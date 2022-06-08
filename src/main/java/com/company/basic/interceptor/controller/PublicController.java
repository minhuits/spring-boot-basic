package com.company.basic.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interceptor/public")
public class PublicController {

    @GetMapping("/hello")
    public String hello() {
        return "public hello";
    }
}
