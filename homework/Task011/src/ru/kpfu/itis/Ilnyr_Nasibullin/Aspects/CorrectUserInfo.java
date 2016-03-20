package ru.kpfu.itis.Ilnyr_Nasibullin.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by softi on 20.03.2016.
 */
@Aspect
public class CorrectUserInfo {
    @Around("execution(* RegistrationServlet.doPost())")
    public Object loginValidation(ProceedingJoinPoint jp) throws Throwable {
        HttpServletRequest request = (HttpServletRequest) jp.getArgs()[0];
        HttpServletResponse response = (HttpServletResponse) jp.getArgs()[1];
        String email = request.getParameter("email");
        String user = request.getParameter("login");
        String password = request.getParameter("password");
        boolean b = email.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
        boolean b1 = user.matches("(\\w){6,}");
        boolean b2 = password.matches("(\\w){6,}");
        if (b && b1 && b2) {
            return jp.proceed();
        } else {
            response.sendRedirect("/registration");
        }
        return null;

    }
}
