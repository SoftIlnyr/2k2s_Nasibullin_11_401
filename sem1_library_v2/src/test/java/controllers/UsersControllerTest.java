package controllers;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import ru.kpfu.itis.SoftIlnyr.mvc.controllers.UsersController;

import java.security.Principal;

import static org.mockito.Mockito.mock;

/**
 * Created by softi on 10.05.2016.
 */
public class UsersControllerTest {
    private static UsersController usersController;

    @BeforeClass
    public static void init() {
        usersController = new UsersController();
    }

    @Test
    public void notLoggedInLoginPageShouldWorkCorrect() {
        ModelMap modelMap = mock(ModelMap.class);
        Principal principal = null;
        Assert.assertEquals(usersController.login(modelMap, principal), "/login");
    }
    @Test

    public void loggedInLoginPageShouldWOrkCOrrect() {
        ModelMap modelMap = mock(ModelMap.class);
        Principal principal = mock(Principal.class);
        Assert.assertEquals(usersController.login(modelMap, principal), "redirect:/test");
    }

    @Test
    public void notLoggedRegistrationShouldWorkCorrect() {
        ModelMap modelMap = mock(ModelMap.class);
        Principal principal = null;
        Assert.assertEquals(usersController.registrationGet(modelMap, principal), "/registration");
    }

    @Test
    public void loggedRegistrationShouldWorkCorrect() {
        ModelMap modelMap = mock(ModelMap.class);
        Principal principal = mock(Principal.class);
        Assert.assertEquals(usersController.registrationGet(modelMap, principal), "redirect:/test");
    }

}
