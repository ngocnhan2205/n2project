package com.n2.portal.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by buibichngoc on 1/5/2017.
 */
@Aspect
public class AspectController {

    @Before("execution(* com.n2.portal.controller..*.*(..)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("tét ----------------------");
    }
}
