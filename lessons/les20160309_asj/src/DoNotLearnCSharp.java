import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by softi on 09.03.2016.
 */
public class DoNotLearnCSharp implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (methodInvocation.getMethod().getName().equals("learnLanguage")) {
            if ("C#".equals(methodInvocation.getMethod().getParameters()[0])) {
                System.out.println("Learn Java instead!");
                return null;
            }
        }
        return methodInvocation.proceed();
    }
}
