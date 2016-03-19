import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.time.DayOfWeek;
import java.util.Calendar;

/**
 * Created by softi on 02.03.2016.
 */
public class DoNotWorkAtSundays implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (methodInvocation.getMethod().getName().equals("work")) {
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(calendar.DAY_OF_WEEK);
            System.out.println(day);
            if (day == calendar.WEDNESDAY) {
                System.out.println("It's Sunday! You shouldn't work!");
            }
        }
        return methodInvocation.proceed();
    }
}
