package com.andres.springboot.aop.sprinboot_aop.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(String com.andres.springboot.aop.sprinboot_aop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut(){
    }


    @Pointcut("execution(String com.andres.springboot.aop.sprinboot_aop.services.GreetingService.*(..))")
    public void greetingFooAspectPointCut(){
    }

}
