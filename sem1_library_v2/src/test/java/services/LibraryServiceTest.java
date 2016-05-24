package services;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Library;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.LibrariesRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL.LibrariesServiceIMPL;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by softi on 24.05.2016.
 */
public class LibraryServiceTest {
    private static LibrariesServiceIMPL librariesService;
    private static Library library;

    @BeforeClass
    public static void init() {
        librariesService = new LibrariesServiceIMPL();
        librariesService.librariesRepository = mock(LibrariesRepository.class);
        library = mock(Library.class);
    }

    @Test
    public void findByIdShouldWorkCorrect() {
        when(librariesService.librariesRepository.findOne(5)).thenReturn(library);
        Assert.assertEquals(librariesService.findById(5), library);

    }
}
