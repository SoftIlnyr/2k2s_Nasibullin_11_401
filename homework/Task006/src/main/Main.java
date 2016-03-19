package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("main/spring-config.xml");
        Destroyer d1 = (Destroyer) ac.getBean("destroyer");
        d1.attackPoint(1, 5);
        Fleet f1 = (Fleet) ac.getBean("fleet");
        f1.fullAttackTarget(d1);
        f1.fullMoveToPoint(5, 10);
    }
}
