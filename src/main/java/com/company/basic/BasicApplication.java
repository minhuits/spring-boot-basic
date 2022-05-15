package com.company.basic;

import com.company.basic.ioc.ApplicationContextProvider;
import com.company.basic.ioc.Base64Encoder;
import com.company.basic.ioc.Encoder;
import com.company.basic.ioc.UrlEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.util.Base64;

@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);

        System.out.println(Base64.getEncoder().encodeToString("steve@naver.com".getBytes()));
    }

}