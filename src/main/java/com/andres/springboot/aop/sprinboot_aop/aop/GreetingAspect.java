package com.andres.springboot.aop.sprinboot_aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(GreetingAspect.class);


    @Before(value = "GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint join){

        String method = join.getSignature().getName();
        String args = Arrays.toString(join.getArgs());

        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    @After(value = "GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint join){

        String method = join.getSignature().getName();
        String args = Arrays.toString(join.getArgs());

        logger.info("Despues: " + method + " con los argumentos " + args);
    }

    @AfterReturning(value = "GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint join){

        String method = join.getSignature().getName();
        String args = Arrays.toString(join.getArgs());

        logger.info("Despues de retornar: " + method + " con los argumentos " + args);
    }

    @AfterThrowing(value = "GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint join){

        String method = join.getSignature().getName();
        String args = Arrays.toString(join.getArgs());

        logger.info("Despues de lanzar la excepcion: " + method + " con los argumentos " + args);
    }

    @Around(value = "GreetingServicePointcuts.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;

        try {
            logger.info("El metodo " + method + "() con los parametros " + args);
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "() retorna el resultado: " + result);
            return result;
        } catch (Throwable e){
            logger.info("Error en la llamada del metodo " + method + "()");
            throw e;
        }
    }
}
