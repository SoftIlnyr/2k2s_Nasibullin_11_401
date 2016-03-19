import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by softi on 24.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        ComplexNumber n1 = (ComplexNumber) ac.getBean("n1");
        ComplexNumber n2 = (ComplexNumber) ac.getBean("n2");

        System.out.println(n1.equals(n2));

        ComplexMatrix2x2 cm1 = (ComplexMatrix2x2) ac.getBean("cm1");
        ComplexMatrix2x2 cm2 = (ComplexMatrix2x2) ac.getBean("cm2");
        ComplexMatrix2x2 cm3 = cm1.mult(cm2);
        System.out.println(cm3);
    }
}
