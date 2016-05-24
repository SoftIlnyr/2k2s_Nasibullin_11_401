package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField nickname;
    public PasswordField password;
    private static String BASE_URL = "http://localhost:8080/";

    public void doLogin(ActionEvent actionEvent) throws IOException {
//        String nickname = (String) this.nickname.getCharacters();
//        String password = (String) this.password.getCharacters();
        FXMLLoader books = new FXMLLoader(getClass().getResource("/fxml/books.fxml"));
        Parent root2 = books.load();
        Scene scene = new Scene(root2);
        Stage stage = (Stage) nickname.getScene().getWindow();
        stage.setScene(scene);



    }
}
