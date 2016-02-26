import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by softi on 24.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println(Student.getN() + "");
        Institute i1 = (Institute) ac.getBean("itis");
        System.out.println(i1);
        Student s1 = (Student) ac.getBean("aygul");
        System.out.println(s1);
        System.out.println(Student.getN() + "");
        Student s2 = (Student) ac.getBean("sasha");
        System.out.println(s2);
        System.out.println(Student.getN() + "");
        System.out.println(s1.equals(s2));

        Univer u1 = (Univer) ac.getBean("kfu");
        Univer u2 = (Univer) ac.getBean("kfu");

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u1.equals(u2));

        s1.goToLessons();
        s2.printSchedule();
    }
}
