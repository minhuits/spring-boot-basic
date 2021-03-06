package com.company.basic.aop.controller;

import com.company.basic.aop.annotation.Decode;
import com.company.basic.aop.annotation.Timer;
import com.company.basic.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aop")
public class AopApiController {

    @GetMapping("get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        // db logic
        Thread.sleep(100 * 2);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        System.out.println("put");
        System.out.println(user);
        return user;
    }

}
