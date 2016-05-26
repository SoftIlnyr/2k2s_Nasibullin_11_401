package ru.kpfu.itis.SoftIlnyr.controllers;

import javafx.scene.Node;
import javafx.stage.Stage;
import ru.kpfu.itis.SoftIlnyr.Controller;

/**
 * Created by softi on 25.05.2016.
 */
public abstract class AbstractController implements Controller {
    private Node view;
    private Stage stage;

    public Node getView() {
        return view;
    }

    public void setView (Node view){
        this.view = view;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}
