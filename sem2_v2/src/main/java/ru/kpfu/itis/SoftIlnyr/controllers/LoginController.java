package ru.kpfu.itis.SoftIlnyr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.SoftIlnyr.SpringFXMLLoader;
import ru.kpfu.itis.SoftIlnyr.entities.Book;
import ru.kpfu.itis.SoftIlnyr.entities.User;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 25.05.2016.
 */
@Component
public class LoginController extends AbstractController {
    public TextField nickname;
    public PasswordField password;

    @Autowired
    UserConfig userConfig;

    @Autowired
    BooksController booksController;

    public void doLogin(ActionEvent actionEvent) {
        String nickname = this.nickname.getCharacters().toString();
        String password = this.password.getCharacters().toString();
        userConfig.setNickname(nickname);
        userConfig.setPassword(password);
        System.out.println(nickname);
        System.out.println(password);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/login";
        List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<>();
        httpMessageConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(httpMessageConverters);
        User user = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(userConfig.createHeaders()), User.class).getBody();
        userConfig.setUser(user);

        BooksController booksController = (BooksController) SpringFXMLLoader.load("/fxml/books.fxml", getStage());
        Scene scene = new Scene((Parent) booksController.getView());
        super.getStage().setScene(scene);
    }

    @Override
    public Node getView() {
        return super.getView();
    }

    @Override
    public void setView(Node view) {
        super.setView(view);
    }
}
