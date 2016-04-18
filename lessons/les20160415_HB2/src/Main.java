import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import ru.kpfu.itis.SoftIlnyr.entities.Author;
import ru.kpfu.itis.SoftIlnyr.entities.Book;

/**
 * Created by softi on 15.04.2016.
 */
public class Main {
    private static final Session session = HibernateUtil.getSession();

    public static void main(String[] args) {
//        Transaction t = session.beginTransaction();
//        Author author = new Author();
//        author.setFirstName("Джонатан");
//        author.setLastName("Страуд");
//        session.save(author);
//        t.commit();
        //


        Author author = (Author) session.createCriteria(Author.class).add(Restrictions.eq("firstName", "Джонатан")).list().get(0);
        Transaction t = session.beginTransaction();
        Book book = new Book();
        book.setTitle("Посох Глэдстоуна");
        book.setEdition("Эксмо");
        book.setIssue(2005);
        book.setLanguage("Russian");
        book.setAuthor(author);
        session.save(book);
        t.commit();

    }
}
