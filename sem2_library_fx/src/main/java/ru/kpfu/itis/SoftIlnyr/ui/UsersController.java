package ru.kpfu.itis.SoftIlnyr.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.SoftIlnyr.entities.User;
import ru.kpfu.itis.SoftIlnyr.services.INTERFACES.UsersService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by softi on 16.05.2016.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class UsersController {

    private Logger logger = LoggerFactory.getLogger(UsersController.class);

    // Инъекции Spring
    @Autowired
    private UsersService usersService;

    // Инъекции JavaFX
    @FXML
    private TableView<User> table;
    @FXML private TextField txtName;
    @FXML private TextField txtSurname;
    @FXML private TextField txtEmail;

    // Variables
    private ObservableList<User> data;

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
        List<User> users = usersService.findAll();
        data = FXCollections.observableArrayList(users);

        // Столбцы таблицы
        TableColumn<User, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<User, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<User, String> surnameColumn = new TableColumn<>("Фамилия");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<User, String> emailColumn = new TableColumn<>("E-mail");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().setAll(idColumn, nameColumn, surnameColumn, emailColumn);

        // Данные таблицы
        table.setItems(data);
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Добавить".
     * Привязан к кнопке в FXML файле представления.
     */
    @FXML
    public void addContact() {
    }
}
