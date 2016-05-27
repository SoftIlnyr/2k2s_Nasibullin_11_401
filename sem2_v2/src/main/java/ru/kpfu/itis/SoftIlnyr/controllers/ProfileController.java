package ru.kpfu.itis.SoftIlnyr.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.SoftIlnyr.SpringFXMLLoader;
import ru.kpfu.itis.SoftIlnyr.entities.Book;
import ru.kpfu.itis.SoftIlnyr.entities.Library;
import ru.kpfu.itis.SoftIlnyr.entities.Presence;
import ru.kpfu.itis.SoftIlnyr.entities.Talon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 27.05.2016.
 */
public class ProfileController extends AbstractController {

    public TableView table;
    @Autowired
    LoginController loginController;

    @Autowired
    BooksController booksController;

    @Autowired
    UserConfig userConfig;

    public void initialize() {
        System.out.println(userConfig.getUser());

        ObservableList<Talon> data = FXCollections.observableArrayList(userConfig.getUser().getTalons());

        // Столбцы таблицы
        TableColumn<Talon, String> bookColumn = new TableColumn<>("Книга");
        bookColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<String>(param.getValue().getBook().getTitle()));

        TableColumn<Talon, String> libraryColumn = new TableColumn<>("Библиотека");
        libraryColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<String>(param.getValue().getLibrary().getName()));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Статус");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.getColumns().setAll(bookColumn, libraryColumn, authorColumn);

        // Данные таблицы
        table.setItems(data);
    }


    public void logout(ActionEvent actionEvent) {
        loginController.resetInfo();
    }

    public void toBooks(ActionEvent actionEvent) {
        if (booksController.getView() == null) {
            booksController = (BooksController) SpringFXMLLoader.load("/fxml/profile.fxml", getStage());
            Scene scene = new Scene((Parent) booksController.getView());
            super.getStage().setScene(scene);
        } else {
            Scene scene = booksController.getView().getScene();
            super.getStage().setScene(scene);
        }
    }
}
