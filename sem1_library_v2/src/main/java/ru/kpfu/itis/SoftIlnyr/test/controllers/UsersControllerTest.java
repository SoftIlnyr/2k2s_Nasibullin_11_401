package ru.kpfu.itis.SoftIlnyr.test.controllers;

import org.eclipse.core.runtime.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by softi on 07.05.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
@WebAppConfiguration
public class UsersControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private UsersService usersServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

//    @Before
//    public void setUp() {
//        Mockito.reset(usersServiceMock);
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @Test
//    public void registrationPostShouldWorkCorrect() throws Exception {
//        this.mockMvc.perform(get("/")).andExpect(status().isOk());
//
//    }
}
