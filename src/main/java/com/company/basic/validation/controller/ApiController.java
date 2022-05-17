package com.company.basic.validation.controller;

import com.company.basic.validation.dto.User2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/validation")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User2 user, BindingResult bindingResult) {
        System.out.println("user : " + user);

        if(bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();

            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError) objectError;
                String massage = objectError.getDefaultMessage();

                System.out.println("field : " +fieldError.getField());
                System.out.println("message : " + massage);

                stringBuffer.append("field : " + fieldError.getField());
                stringBuffer.append("message : " + massage);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stringBuffer.toString());
        }

        return ResponseEntity.ok(user);
    }
}
