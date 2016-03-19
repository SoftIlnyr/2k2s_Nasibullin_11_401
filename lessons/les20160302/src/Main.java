import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.softilnyr.*;

/**
 * Created by softi on 02.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        Institute i = ac.getBean(ITInstitute.class);
        //ru.kpfu.itis.softilnyr.Institute i = (ru.kpfu.itis.softilnyr.Institute) ac.getBean("itinstitute"); //обращение по имени института

        System.out.println(i);

        Univer u = ac.getBean(Univer.class);
        System.out.println(u);

        Student student = ac.getBean(Student.class);
        System.out.println(student);
    }
}
