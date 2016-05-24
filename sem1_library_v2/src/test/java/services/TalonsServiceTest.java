package services;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Talon;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.TalonsRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL.TalonsServiceIMPL;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by softi on 24.05.2016.
 */
public class TalonsServiceTest {
    private static TalonsServiceIMPL talonsService;
    private static Talon talon;

    @BeforeClass
    public static void init() {
        talonsService = new TalonsServiceIMPL();
        talonsService.talonsRepository = mock(TalonsRepository.class);
        talon = mock(Talon.class);
    }

    @Test
    public void findByIdShouldWorkCorrect() {
        when(talonsService.talonsRepository.findOne(5)).thenReturn(talon);
        Assert.assertEquals(talonsService.findById(5), talon);
    }

    @Test
    public void findAllShouldWorkCorrect() {
        List<Talon> talons = new ArrayList<>();
        Talon t1 = mock(Talon.class);
        Talon t2 = mock(Talon.class);
        Talon t3 = mock(Talon.class);
        talons.add(t1);
        talons.add(t2);
        talons.add(t3);
        when(talonsService.talonsRepository.findAll()).thenReturn(talons);
        Assert.assertEquals(talonsService.findAll(), talons);
    }
}
