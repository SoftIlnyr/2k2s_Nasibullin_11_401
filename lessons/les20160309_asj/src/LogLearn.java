import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by softi on 09.03.2016.
 */
@Aspect
public class LogLearn {

    @Around("execution(* *.learnLanguage(String))")
    public Object learningLanguage(ProceedingJoinPoint jp) throws Throwable {
        String lang = (String) jp.getArgs()[0];
        if ("c#".equals(lang.toLowerCase())) {
            System.out.println("Learn Java instead!");
            return null;
        }
        return jp.proceed();
    }
}
