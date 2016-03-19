import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by softi on 19.03.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Server server = (Server) ac.getBean("server");
        server.go();
    }
}
