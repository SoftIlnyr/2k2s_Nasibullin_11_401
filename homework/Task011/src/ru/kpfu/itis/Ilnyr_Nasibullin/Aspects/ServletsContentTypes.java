package ru.kpfu.itis.Ilnyr_Nasibullin.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by softi on 20.03.2016.
 */
@Aspect
public class ServletsContentTypes {

    @Before("execution(ru.kpfu.itis.Ilnyr_Nasibullin.Controllers *.*())")
    public Object servletBeforeConfiguration(ProceedingJoinPoint jp) throws Throwable {
        HttpServletResponse response = (HttpServletResponse) jp.getArgs()[1];
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        return jp.proceed();
    }
}
