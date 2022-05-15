package com.company.basic.aop.aop;

import jdk.jshell.MethodSnippet;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.company.basic.aop.controller..*.*(..))")
    private void cut() {}

    @Before("cut()")
    public void before(JoinPoint joinPoint) {

        MethodSignature methodSnippet = (MethodSignature) joinPoint.getSignature();
        Method method = methodSnippet.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();

        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "obj")
    public void afterReturn(JoinPoint joinPoint, Object obj) {
        System.out.println("object");
        System.out.println(obj);
    }
}
