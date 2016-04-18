import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import ru.kpfu.SoftIlnyr.entities.StudentsEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by softi on 08.04.2016.
 */
public class Task01_HQL {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            Query query = session.createQuery("from StudentsEntity ");
            List<StudentsEntity> students = query.list();
            for (StudentsEntity student : students) {
                System.out.println(student.getName());
            }
        } finally {
            session.close();
        }
    }
}
