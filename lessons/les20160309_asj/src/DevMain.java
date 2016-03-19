import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by softi on 09.03.2016.
 */
public class DevMain {
    public static void main(String[] args) {
        Developer developer = new Developer("Ilnyr");
        ProxyFactory pf = new ProxyFactory(developer);
        pf.addAdvice(new DoNotLearnCSharp());
        Developer developer1 = (Developer) pf.getProxy();
        developer1.learnLanguage("c#");
    }
}
