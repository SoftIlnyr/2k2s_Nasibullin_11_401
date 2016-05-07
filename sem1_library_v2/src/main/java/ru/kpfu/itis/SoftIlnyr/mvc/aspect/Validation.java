package ru.kpfu.itis.SoftIlnyr.mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by softi on 03.05.2016.
 */
@Aspect
public class Validation {

    @Around("execution(* ru.kpfu.itis.SoftIlnyr.mvc.controllers.*(*))")
    public java.lang.Object message(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
