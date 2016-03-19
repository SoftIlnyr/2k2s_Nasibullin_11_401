import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Calendar;

/**
 * Created by softi on 09.03.2016.
 */
@Aspect
public class LogWork {
    @Around("execution(* Developer.work())")
    public Object loggingWork(ProceedingJoinPoint jp) throws Throwable {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(calendar.DAY_OF_WEEK);
        if (day == calendar.WEDNESDAY) {
            System.out.println("It's Sunday! You shouldn't work!");
            return null;
        }
        return jp.proceed();
    }

}
