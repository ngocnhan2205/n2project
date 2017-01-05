package com.n2.portal.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by buibichngoc on 1/5/2017.
 */
@Aspect
public class AspectController {

    private static final Logger log = Logger.getLogger("logController");

    @Before("execution(* com.n2.portal.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Running function " + joinPoint.getSignature().getName() + " of controller " + joinPoint.getThis().getClass());
    }


    @AfterThrowing(pointcut = "execution(* com.n2.portal.controller.*.*(..))", throwing = "error")
    public void logException(JoinPoint joinPoint, Throwable error) {
        log.error("Exception " + joinPoint.getSignature().getName() + "of controller " + joinPoint.getThis().getClass() + " " + error);
    }

    @AfterReturning(pointcut = "execution(* com.n2.portal.controller.*.*(..))", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        log.info("---------------------- " + joinPoint.getSignature().getName() + "-------------------------------------");
        log.info("Result : " + result);
        log.info("-------------------------------------------------------------------------------");
    }
}
