package ru.kpfu.itis.SoftIlnyr.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.SoftIlnyr.entities.Book;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 25.05.2016.
 */
@Component
public class BooksController extends AbstractController {
    public TableView table;
    public TextField title;
    public TextField author;
    public TextField edition;
    public TextField issue;
    @Autowired
    UserConfig userConfig;

    public void initialize() {
        System.out.println(userConfig.getNickname());
        System.out.println(userConfig.getPassword());
//        stage.setScene(scene);
//        stage.setScene(new Scene(booksController.getView()));
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/info";
        List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<>();
        httpMessageConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(httpMessageConverters);
        Book[] books = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(userConfig.createHeaders()), Book[].class).getBody();
        System.out.println(books);

        ObservableList<Book> data = FXCollections.observableArrayList(books);

        table.setRowFactory( tv -> {
            TableRow<Book> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    System.out.println(row.getItem().getTitle());
                }
            });
            return row ;
        });

        // Столбцы таблицы
        TableColumn<Book, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Book, String> titleColumn = new TableColumn<>("Название");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Автор");
        authorColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Book, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Book, String> param) {
                return new ReadOnlyObjectWrapper<String>(param.getValue().getAuthor().getName() + " " + param.getValue().getAuthor().getSurname());
            }
        });

        TableColumn<Book, String> editionColumn = new TableColumn<>("Издательство");
        editionColumn.setCellValueFactory(new PropertyValueFactory<>("edition"));

        TableColumn<Book, String> issueColumn = new TableColumn<>("Год выпуска");
        issueColumn.setCellValueFactory(new PropertyValueFactory<>("issue"));

        table.getColumns().setAll(idColumn, titleColumn, authorColumn, editionColumn, issueColumn);

        // Данные таблицы
        table.setItems(data);
    }

    public void doOrder(Event event) {
        System.out.println("Order");
    }
}
