package ru.kpfu.itis.SoftIlnyr.test.services;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.UsersRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL.UsersServiceIMPL;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by softi on 06.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UsersServiceTest {
    @Autowired
    private UsersServiceIMPL usersService;
    @Autowired
    private UsersRepository usersRepository;
    static User user;

    @BeforeClass
    public void init() {
        user = mock(User.class);
    }

    @Test
    public void addUserMethodShouldWorkCorrect() {
        when(user.getId()).thenReturn(5);
        when(usersRepository.save(user)).thenReturn(user);
        Assert.assertEquals(usersService.addUser(user).getId(), user.getId());
    }

}
