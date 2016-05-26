package ru.kpfu.itis.SoftIlnyr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import ru.kpfu.itis.SoftIlnyr.controllers.LoginController;

/**
 * Created by softi on 25.05.2016.
 */
@org.springframework.stereotype.Controller
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginController loginController = (LoginController) SpringFXMLLoader.load("/fxml/login.fxml", primaryStage);
        loginController.setStage(primaryStage);
        Scene scene = new Scene((Parent) loginController.getView());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Legistis Libro");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
