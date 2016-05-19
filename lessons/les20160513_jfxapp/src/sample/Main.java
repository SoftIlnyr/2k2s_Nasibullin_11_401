package sample;


import com.sun.deploy.xml.XMLable;
import com.sun.javafx.geom.Vec2f;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

import static java.lang.Math.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    private int windowWidth = 600;
    private int windowHeight = 600;
    private Node tempNode = null;
    private int clickCount = 0;

    private int labelWidth = 100;
    private int labelHeight = 50;

    public Node getTempNode() {
        return tempNode;
    }

    public void setTempNode(Node tempNode) {
        this.tempNode = tempNode;
    }

    private Scene createScene() {
        Group root = new Group();
        for (int i = 0; i < 13; i++) {
            root.getChildren().add(createLabel());
        }
        Scene scene = new Scene(root, windowWidth, windowHeight);
        addSceneListener(scene);
        return scene;
    }

    private void addSceneListener(Scene scene) {
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (tempNode != null) {
                    if (clickCount == 1) {
                        SequentialTransition st = new SequentialTransition();
                        double destX = event.getSceneX() - tempNode.getLayoutX() - labelWidth / 2;
                        double destY = event.getSceneY() - tempNode.getLayoutY() - labelHeight / 2;
                        RotateTransition rt1 = new RotateTransition(Duration.millis(500), tempNode);
                        rt1.setByAngle(setAngle(event, tempNode));
//                        rt1.play();
                        st.getChildren().add(rt1);
                        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), tempNode);
                        translateTransition.setToX(destX);
                        translateTransition.setToY(destY);
                        translateTransition.setAutoReverse(true);
//                        translateTransition.play();
                        st.getChildren().add(translateTransition);
                        RotateTransition rt2 = new RotateTransition(Duration.millis(500), tempNode);
                        rt2.setToAngle(0);
//                        rt2.play();
                        st.getChildren().add(rt2);
                        st.play();



                        tempNode.setStyle("-fx-background-color: orange;");
//                        tempNode.setLayoutX(event.getSceneX() - labelWidth / 2);
//                        tempNode.setLayoutY(event.getSceneY() - labelHeight / 2);
                        tempNode = null;
                    } else {
                        clickCount++;
                    }
                }
            }
        });
    }

    private Random random = new Random(); // нам нужен рандом!!

    private Label createLabel() {
        Label label = new Label();    // создание билдера для Label
        label.setText("SomeText");            // текстовое значение
        label.setMinWidth(labelWidth);                // возможная ширина
        label.setMinHeight(labelHeight);                // возможная высота
        label.setAlignment(Pos.CENTER);         // выравнивание содержимого по центру
        label.setLayoutX(random.nextInt(windowWidth - 100)); // задание  коорд. Х
        label.setLayoutY(random.nextInt(windowHeight - 50));  // задание  коорд. Y
        label.setStyle("-fx-background-color: orange;");  // зарисуем фон в оранжевый
        addTranslateListener(label);
        return label;
    }

    private Node node;   // ссылка на объект, который будем перетаскивать
    private Vec2f delta; // координаты указателя мыши относительно элемента
    // нужны для того, чтобы не было резкого рывка вначале движения
/*
    private void addTranslateListener(final Node node) {
        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                delta = new Vec2f((float) (mouseEvent.getSceneX() - node.getLayoutX()),
                        (float) (mouseEvent.getSceneY() - node.getLayoutY()));
                // вичисление координат относительно элемeнта
                Main.this.node = node;   // сохраняем ссылку на объект
            }
        });
        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.this.node = null;  // обнулям ссылку на объект
            }
        });
        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (node != null) {
// если есть что перетаскивать, перетаскиваем
                    node.setLayoutX(mouseEvent.getSceneX() - delta.x);
                    node.setLayoutY(mouseEvent.getSceneY() - delta.y);
                }
            }
        });
    }
    */
    boolean isRotate;

    private void addTranslateListener(final Node node) {
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    if (tempNode != null) {
                        tempNode.setStyle("-fx-background-color: orange;");
                    }
                    Timeline timeline = new Timeline();
                    KeyValue keyValue = new KeyValue(node.styleProperty(), "-fx-background-color: red;", Interpolator.DISCRETE);
                    KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
//                    node.setStyle("-fx-background-color: red;");
                    setTempNode(node);
                    clickCount = 0;
                }
//                node.setLayoutX(random.nextInt(windowWidth - 100)); // задание  коорд. Х
//                node.setLayoutY(random.nextInt(windowHeight - 50));  // задание  коорд. Y
            }
        });

        node.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                delta = new Vec2f((float) (mouseEvent.getSceneX() - node.getLayoutX()),
                        (float) (mouseEvent.getSceneY() - node.getLayoutY()));
                Main.this.node = node;
                if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                    isRotate = true;
                }
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.this.node = null;
                isRotate = false;
            }
        });


        node.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent mouseEvent) {
                if (node != null) {
                    if (isRotate) {
                        // подсчет нового угла основуется на подсчета угла между двома векторами
// это несложная математика, и поэтому тут должно быть все понятно)
                        double ang = setAngle(mouseEvent, node);
                        node.setRotate(ang);
                    } else {
                        node.setLayoutX(mouseEvent.getSceneX() - delta.x);
                        node.setLayoutY(mouseEvent.getSceneY() - delta.y);
                    }
                }
            }
        });
    }

    private double setAngle(MouseEvent mouseEvent, Node node) {
        double dx1 = mouseEvent.getSceneX() - node.getLayoutX() - labelWidth/2;
        double dy1 = mouseEvent.getSceneY() - node.getLayoutY() - labelHeight/2;
        double l = Math.sqrt(dx1 * dx1 + dy1 * dy1);
        dx1 /= l; // нормализация
        dy1 /= l; // вектора

        double angle = PI / 2; // за второй вектор было взято
        double dx2 = sin(angle);      // единичный вектор,
        double dy2 = cos(angle);      // который повернутый на 90 градусов

        double cosA = dx1 * dx2 + dy1 * dy2;
        angle = acos(cosA);

        if (dy1 < 0) angle = PI - angle;
        return angle / PI * 180; //в градусы
    }

    public static void main(String[] args) {
        launch(args);
    }
}