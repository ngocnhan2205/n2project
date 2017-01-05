package com.n2.portal.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by buibichngoc on 1/5/2017.
 */
@Aspect
public class AspectController {

    private static final Logger log = Logger.getLogger(AspectController.class);

    @Before("execution(* com.n2.portal.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Running function " + joinPoint.getSignature().getName() + " of controller " + joinPoint.getThis().getClass());
    }

}
