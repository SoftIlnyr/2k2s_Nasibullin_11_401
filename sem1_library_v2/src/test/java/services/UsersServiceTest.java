package services;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.UsersRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL.UsersServiceIMPL;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by softi on 06.05.2016.
 */
public class UsersServiceTest {
    private static UsersServiceIMPL usersService;
    static User user;

    @BeforeClass
    public static void init() {
        usersService = new UsersServiceIMPL();
        usersService.usersRepository = mock(UsersRepository.class);
        user = mock(User.class);
    }

    @Test
    public void addUserMethodShouldWorkCorrect() {
        when(usersService.usersRepository.save(user)).thenReturn(user);
        Assert.assertEquals(usersService.addUser(user), user);
    }

    @Test
    public void findByIdShouldWorkCorrect() {
        when(usersService.usersRepository.findOne(5)).thenReturn(user);
        Assert.assertEquals(usersService.findById(5), user);
    }

    @Test
    public void findAllShouldWorkCorrect() {
        ArrayList<User> list = new ArrayList<>();
        User user1 = mock(User.class);
        when(user1.getId()).thenReturn(5);
        User user2 = mock(User.class);
        when(user2.getId()).thenReturn(2);
        list.add(user1);
        list.add(user2);
        when(usersService.usersRepository.findAll()).thenReturn(list);
        Assert.assertEquals(usersService.findAll(), list);
    }

    @Test
    public void findByNicknameShouldWorkCorrect() {
        when(user.getNickname()).thenReturn("Sample");
        when(usersService.usersRepository.findByNicknameIgnoreCase("Sample")).thenReturn(user);
        Assert.assertEquals(usersService.findByNickname("Sample"), user);
    }

    @Test
    public void findByEmailShouldWorkCorrect() {
        when(user.getEmail()).thenReturn("sample@email.ru");
        when(usersService.usersRepository.findByEmailIgnoreCase("sample@Email.ru")).thenReturn(user);
        Assert.assertEquals(usersService.findByEmail("sample@Email.ru"), user);
    }
}
