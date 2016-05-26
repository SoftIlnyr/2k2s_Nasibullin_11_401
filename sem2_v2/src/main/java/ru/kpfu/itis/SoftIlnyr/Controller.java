package ru.kpfu.itis.SoftIlnyr;

import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Created by softi on 25.05.2016.
 */
public interface Controller {
    Node getView();
    void setView (Node view);

    void setStage(Stage stage);
}
