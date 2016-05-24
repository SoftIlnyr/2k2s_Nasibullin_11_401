package services;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.AuthorsRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL.AuthorsServiceIMPL;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.AuthorsService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by softi on 24.05.2016.
 */
public class AuthorsServiceTest {
    private static AuthorsServiceIMPL authorsService;
    static Author author;

    @BeforeClass
    public static void init() {
        authorsService = new AuthorsServiceIMPL();
        authorsService.authorsRepository = mock(AuthorsRepository.class);
        author = mock(Author.class);
        when(author.getId()).thenReturn(3);
    }

    @Test
    public void findByIdShouldWorkCorrect() {
        when(authorsService.authorsRepository.findOne(3)).thenReturn(author);
        Assert.assertEquals(authorsService.findById(3), author);
    }

}
