package ru.kpfu.itis.Ilnyr_Nasibullin.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by softi on 25.03.2016.
 */
@Aspect
public class SQLInjectionInterception {

    @Around("execution(* ru.kpfu.itis.Ilnyr_Nasibullin.Repositories.*.*(String))")
    public Object catchSQLInjection(ProceedingJoinPoint jp) throws Throwable {
        String query = (String) jp.getArgs()[0];
        if (!(query.contains(" UNION ") | query.contains(";"))) {
            return jp.proceed();
        }
        return null;
    }
}
