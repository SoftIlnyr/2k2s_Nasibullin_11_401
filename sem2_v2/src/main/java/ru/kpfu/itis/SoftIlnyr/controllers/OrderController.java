package ru.kpfu.itis.SoftIlnyr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.SoftIlnyr.SpringFXMLLoader;
import ru.kpfu.itis.SoftIlnyr.entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 27.05.2016.
 */
public class OrderController extends AbstractController {

    public Label bookTitle;
    public ComboBox<String> libraries;
    public TextField period;
    private Book book;

    @Autowired
    LoginController loginController;

    @Autowired
    UserConfig userConfig;

    @Autowired
    BooksController booksController;

    @Autowired
    ProfileController profileController;

    public void backToBooks(ActionEvent actionEvent) {
        Scene scene = booksController.getView().getScene();
        super.getStage().setScene(scene);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void doOrder(ActionEvent actionEvent) {
        int period = Integer.parseInt(this.period.getText());
        int library_id = Integer.parseInt(((String) libraries.getValue()).split(" ")[0]);

        Library library = null;
        for (Presence presence : book.getPresence()) {
            if (presence.getLibrary().getId() == library_id) {
                library = presence.getLibrary();
                break;
            }
        }

        Talon talon = new Talon();
        talon.setBook(this.book);
        talon.setUser(userConfig.getUser());
        talon.setLibrary(library);
        talon.setPeriod(period);

        String url = "http://localhost:8080/rest/order";

        User user = new RestTemplate().exchange(url, HttpMethod.POST, new HttpEntity(talon, userConfig.createHeaders()), User.class).getBody();
        userConfig.setUser(user);

        profileController = (ProfileController) SpringFXMLLoader.load("/fxml/profile.fxml", getStage());
        Scene scene = new Scene((Parent) profileController.getView());
        super.getStage().setScene(scene);
//        List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<>();
//        httpMessageConverters.add(new MappingJackson2HttpMessageConverter());
//        restTemplate.setMessageConverters(httpMessageConverters);
//        restTemplate.postForEntity(url, new HttpEntity<Object>(userConfig.createHeaders()), User.class);
    }

    public void logout(ActionEvent actionEvent) {
        loginController.resetInfo();
    }

    public void toProfile(ActionEvent actionEvent) {
        if (profileController.getView() == null) {
            profileController = (ProfileController) SpringFXMLLoader.load("/fxml/profile.fxml", getStage());
            Scene scene = new Scene((Parent) profileController.getView());
            super.getStage().setScene(scene);
        } else {
            Scene scene = profileController.getView().getScene();
            super.getStage().setScene(scene);
        }
    }
}