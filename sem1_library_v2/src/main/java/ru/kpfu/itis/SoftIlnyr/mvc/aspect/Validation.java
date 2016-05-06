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

    @Around("execution(* ru.kpfu.itis.SoftIlnyr.mvc.entities.User.setEmail(String))")
    public Object validateEmail(ProceedingJoinPoint jp) {
        String email = (String) jp.getArgs()[0];
        String strings = jp.getSignature().toString();
        if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {

        }



        return jp;
    }
}
