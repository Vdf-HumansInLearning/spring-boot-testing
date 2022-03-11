package com.vdf.demo.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.vdf.demo.controller.PetController.*(..))")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        System.out.println("Before " + methodName);
    }

}
