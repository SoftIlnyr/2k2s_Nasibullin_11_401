import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by softi on 02.03.2016.
 */
public class DropPHPPlease implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (methodInvocation.getMethod().getName().equals("learnLanguage")) {
            String language = (String) methodInvocation.getArguments()[0];
            if ("php".equals(language.toLowerCase())) {
                System.out.println("Man, why php?");
            }
        }
        return methodInvocation.proceed();

    }
}
