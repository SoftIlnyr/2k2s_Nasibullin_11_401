package ru.kpfu.itis.SoftIlnyr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.SoftIlnyr.controllers.*;

/**
 * Created by softi on 25.05.2016.
 */
@Configuration
@ComponentScan(basePackages = "ru.kpfu.itis.SoftIlnyr")
public class AppConfig {
    @Bean
    public LoginController loginController() {
        return new LoginController();
    }

    @Bean
    public BooksController booksController() {
        return new BooksController();
    }

    @Bean
    public OrderController orderController() {
        return new OrderController();
    }

    @Bean
    public ProfileController profileController() {
        return new ProfileController();
    }

    @Bean
    public UserConfig userConfig() {
        return new UserConfig();
    }

}
