package com.company.basic.client.controller;

import com.company.basic.client.dto.UserResponse;
import com.company.basic.client.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final RestTemplateService restTemplateService;

    public ClientController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/hello")
    public UserResponse getHello() {
//        return restTemplateService.post();
        restTemplateService.post();
        return new UserResponse();
    }
}
