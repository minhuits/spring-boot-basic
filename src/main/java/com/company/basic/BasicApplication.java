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

@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();

        // Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        // UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        Encoder encoder = context.getBean("urlEncode", Encoder.class);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        String result = encoder.encode(url);
        System.out.println(result);
    }

}

@Configuration
class AppConfig {

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder encoder) {
        return new Encoder(encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder encoder) {
        return new Encoder(encoder);
    }
}