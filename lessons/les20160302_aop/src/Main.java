import org.apache.commons.logging.Log;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by softi on 02.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        Developer d = new Developer();

        ProxyFactory pf = new ProxyFactory(d);
        pf.addAdvice(new LogBefore());
        pf.addAdvice(new DropPHPPlease());
        pf.addAdvice(new DoNotWorkAtSundays());
        Developer d1 = (Developer) pf.getProxy();
        Developer d2 = (Developer) pf.getProxy();


        d1.learnLanguage("Java");
        d2.learnLanguage("php");
        d1.work();
    }
}
