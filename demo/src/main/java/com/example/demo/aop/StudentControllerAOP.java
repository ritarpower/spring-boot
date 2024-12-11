package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentControllerAOP {

    @Before("execution(* com.example.demo.controller.StudentController.showCreateForm(..))")
    public void beforeJoinCreateForm(JoinPoint joinPoint) {
        System.out.printf("""
                Before %s invoke
                """ ,joinPoint.getSignature().getName());
    }
}
