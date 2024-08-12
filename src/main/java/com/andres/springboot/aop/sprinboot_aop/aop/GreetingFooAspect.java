package com.andres.springboot.aop.sprinboot_aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Before(value = "GreetingServicePointcuts.greetingFooAspectPointCut()")
    public void loggerBefore(JoinPoint join){

        String method = join.getSignature().getName();
        String args = Arrays.toString(join.getArgs());

        logger.info("Antes del primer Aspect: " + method + " invocado con los parametros" + args);
    }

}
