import main.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        Destroyer d1 = ac.getBean(Destroyer.class);
        EpicMachine e1 = (EpicMachine) ac.getBean("epic");
        Helicarier h1 = ac.getBean(Helicarier.class);
        Jackdaw j1 = ac.getBean(Jackdaw.class);
        Nautilus n1 = ac.getBean(Nautilus.class);
        QueenAnnVengeance q1 = (QueenAnnVengeance) ac.getBean("qav");
        Fleet f1 = ac.getBean(Fleet.class);
        f1.addWarship(d1);
        f1.addWarship(e1);
        f1.addWarship(h1);
        f1.addWarship(j1);
        f1.addWarship(n1);
        f1.addWarship(q1);
        f1.fullAttackTarget(d1);
        f1.fullMoveToPoint(10, 3);
    }
}
