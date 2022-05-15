package com.company.basic.ioc;

import com.company.basic.ioc.IEncoder;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base74Encoder")
public class Base64Encoder implements IEncoder {

    public String encode(String massage) {
        return Base64.getEncoder().encodeToString(massage.getBytes());
    }
}
