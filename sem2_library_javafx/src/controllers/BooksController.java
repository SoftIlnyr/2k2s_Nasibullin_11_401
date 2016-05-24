package controllers;

import entities.Book;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by softi on 22.05.2016.
 */
public class BooksController {
    public TableView table;
    public TextField title;
    public TextField author;
    public TextField edition;
    public TextField issue;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {

//        List<Book> users = usersService.findAll();
//        data = FXCollections.observableArrayList(users);
//
//        // Столбцы таблицы
//        TableColumn<User, String> idColumn = new TableColumn<>("ID");
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<User, String> nameColumn = new TableColumn<>("Имя");
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//
//        TableColumn<User, String> surnameColumn = new TableColumn<>("Фамилия");
//        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
//
//        TableColumn<User, String> emailColumn = new TableColumn<>("E-mail");
//        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//        table.getColumns().setAll(idColumn, nameColumn, surnameColumn, emailColumn);
//
//        // Данные таблицы
//        table.setItems(data);
    }

}
