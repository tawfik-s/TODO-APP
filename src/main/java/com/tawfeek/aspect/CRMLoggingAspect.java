package com.tawfeek.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger myLogger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.tawfeek.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.tawfeek.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.tawfeek.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){}

    //let's add before advice

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){

        String theMethod=joinPoint.getSignature().getName();
        myLogger.info("====>in @Before calling method: "+theMethod);

        Object[] args=joinPoint.getArgs();
        for(Object x:args){
            myLogger.info("===>arg: "+args);
        }

    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint joinPoint,Object theResult){
        String theMethod=joinPoint.getSignature().getName();
        myLogger.info("====>in @AfterReturning calling method: "+theMethod);
        myLogger.info("====>the Result is  "+theResult);
    }



}
