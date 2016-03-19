import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.test.context.transaction.BeforeTransaction;

import java.lang.reflect.Method;

/**
 * Created by softi on 02.03.2016.
 */
public class LogBefore implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Method " + method.getName() + " is called");
    }
}
