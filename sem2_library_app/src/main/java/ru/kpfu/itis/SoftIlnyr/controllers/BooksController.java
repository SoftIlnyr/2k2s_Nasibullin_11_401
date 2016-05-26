package ru.kpfu.itis.SoftIlnyr.controllers;

import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by softi on 25.05.2016.
 */
public class BooksController {
    @Autowired
    UserConfig userConfig;

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
}
