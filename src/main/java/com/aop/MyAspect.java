package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Aspect需與Component同時使用
 */
@Aspect
@Component
public class MyAspect {
    /**
     * @Before("execution(* com.aop.Dog.*(..))")
     * public void before(){
     * System.out.println("is before");
     * }
     * @After("execution(* com.aop.Dog.*(..))")
     * public void after(){
     * System.out.println("is after");
     * }
     */

    @Around("execution(* com.aop.Dog.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before");
        Object obj = pjp.proceed();
        System.out.println("around after");
        return obj;
    }
}
