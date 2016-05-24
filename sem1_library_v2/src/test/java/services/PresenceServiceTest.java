package services;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Presence;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.PresenceRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL.PresenceServiceIMPL;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by softi on 24.05.2016.
 */
public class PresenceServiceTest {
    private static PresenceServiceIMPL presenceService;

    @BeforeClass
    public static void init() {
        presenceService = new PresenceServiceIMPL();
        presenceService.presenceRepository = mock(PresenceRepository.class);
    }

    @Test
    public void findAllShouldWorkCorrect() {
        List<Presence> presences = new ArrayList<>();
        Presence p1 = mock(Presence.class);
        Presence p2 = mock(Presence.class);
        Presence p3 = mock(Presence.class);
        presences.add(p1);
        presences.add(p2);
        presences.add(p3);
        when(presenceService.presenceRepository.findAll()).thenReturn(presences);
        Assert.assertEquals(presenceService.findAll(), presences);
    }
}
