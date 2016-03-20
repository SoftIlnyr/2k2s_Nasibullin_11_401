package ru.kpfu.itis.Ilnyr_Nasibullin.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by softi on 20.03.2016.
 */
@Aspect
public class CorrectEmail {
    //Task013
    @Around("execution(* *.setEmail(String))")
    public Object correctEmail(ProceedingJoinPoint jp) throws Throwable {
        String email = (String) jp.getArgs()[0];
        boolean b = email.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
        if (b) {
            return jp.proceed();
        }
        return null;
    }
}
