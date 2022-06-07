package com.company.basic.filter.controller;

import com.company.basic.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/filter/user")
public class FilterController {

    @PostMapping("")
    public User user(@RequestBody User user) {

        log.info("user : {}", user);

        return user;
    }
}
