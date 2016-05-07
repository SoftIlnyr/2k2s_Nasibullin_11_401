package ru.kpfu.itis.SoftIlnyr.test.controllers;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

/**
 * Created by softi on 07.05.2016.
 */
@Configuration
public class TestContext {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename("i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);

        return messageSource;
    }

    @Bean
    public UsersService usersService() {
        return Mockito.mock(UsersService.class);
    }
}
