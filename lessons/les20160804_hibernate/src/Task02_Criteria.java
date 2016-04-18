import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import ru.kpfu.SoftIlnyr.entities.SubjectsEntity;

import java.util.List;

/**
 * Created by softi on 08.04.2016.
 */
public class Task02_Criteria {
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
            Criteria criteria = session.createCriteria(SubjectsEntity.class);
            criteria.add(Restrictions.lt("maxS", 15));
            List<SubjectsEntity> subjects = criteria.list();
            for (SubjectsEntity subject : subjects) {
                System.out.println(subject.getTitle());
            }
        } finally {
            session.close();
        }
    }
}
