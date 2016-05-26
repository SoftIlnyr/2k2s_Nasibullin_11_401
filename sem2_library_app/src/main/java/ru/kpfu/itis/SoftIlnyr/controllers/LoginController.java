package ru.kpfu.itis.SoftIlnyr.controllers;

import ch.qos.logback.classic.pattern.MessageConverter;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.SoftIlnyr.ConfigurationControllers;
import ru.kpfu.itis.SoftIlnyr.entities.Book;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 16.05.2016.
 */
@Controller
@Lazy
public class LoginController {
    public TextField nickname;
    public PasswordField password;

    @Autowired
    UserConfig userConfig;

    @Qualifier("booksView")
    @Autowired
    private ConfigurationControllers.View booksView;

    // Инъекции Spring
    // Variables

    /**
     * Инициализация контроллера от JavaFX.
     * Метод вызывается после того как FXML загрузчик произвел инъекции полей.
     *
     * Обратите внимание, что имя метода <b>обязательно</b> должно быть "initialize",
     * в противном случае, метод не вызовется.
     *
     * Также на этом этапе еще отсутствуют бины спринга
     * и для инициализации лучше использовать метод,
     * описанный аннотацией @PostConstruct,
     * который вызовется спрингом, после того, как им будут произведены все инъекции.
     */
    @FXML
    public void initialize() {
    }

    /**
     * На этом этапе уже произведены все возможные инъекции.
     */
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {

    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Добавить".
     * Привязан к кнопке в FXML файле представления.
     */
    @FXML
    public void doLogin() throws IOException {
        String nickname = this.nickname.getCharacters().toString();
        String password = this.password.getCharacters().toString();
        userConfig.setNickname(nickname);
        userConfig.setPassword(password);
        System.out.println(nickname);
        System.out.println(password);
        Stage stage = getStage();
        stage.setScene(new Scene(booksView.getView()));

//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/rest/info";
//        List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<>();
//        httpMessageConverters.add(new MappingJackson2HttpMessageConverter());
//        restTemplate.setMessageConverters(httpMessageConverters);
//        Book[] book = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(userConfig.nickname, userConfig.password)), Book[].class).getBody();
//        System.out.println(book);
    }

    private Stage getStage() {
        return (Stage) nickname.getScene().getWindow();
    }

    HttpHeaders createHeaders( String username, String password ){
        return new HttpHeaders(){
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")) );
                String authHeader = "Basic " + new String( encodedAuth );
                set( "Authorization", authHeader );
            }
        };
    }
}
