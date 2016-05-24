package services;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.BooksRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL.BooksServiceIMPL;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by softi on 24.05.2016.
 */
public class BookServiceTest {
    private static BooksServiceIMPL booksService;
    static Book book;

    @BeforeClass
    public static void init() {
        booksService = new BooksServiceIMPL();
        booksService.booksRepository = mock(BooksRepository.class);
        book = mock(Book.class);
    }

    @Test
    public void findByIdShouldWorkCorrect() {
        when(booksService.booksRepository.findOne(5)).thenReturn(book);
        Assert.assertEquals(booksService.findById(5), book);
    }


}
