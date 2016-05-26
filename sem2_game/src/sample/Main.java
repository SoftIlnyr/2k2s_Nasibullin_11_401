package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private int windowWidth = 800;
    private int windowsHeight = 600;
    private boolean flag;
    private int timer = 500;
    private int disap = 300;
    private Timeline circleSpawner;
    private Group root;
    private int count;
    private int speed;
    private Stage gamestage;
    private Label info;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Кружочки");
        Group root = new Group();
        Button button = new Button("Начать игру");
        button.setMinHeight(100);
        button.setMinWidth(400);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                startGame();
            }
        });

        root.getChildren().add(button);
        Scene scene = new Scene(root, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void startGame() {
        flag = true;
        gamestage = new Stage();
        gamestage.setTitle("Жми на кружочки!");
//        primaryStage.setFullScreen(true);
        root = new Group();
        count = 0;
        speed = 5000;
        Scene scene = new Scene(root, windowWidth, windowsHeight);
//        root.getChildren().add(createCircle());
        gamestage.setScene(scene);
        gamestage.show();

        info = new Label("Score: " + count);
        root.getChildren().add(info);
        circleSpawner = new Timeline(
                new KeyFrame(
                        Duration.millis(timer),
                        ae -> {
                            root.getChildren().add(createCircle());
                        }
                )
        );

        circleSpawner.setCycleCount(Timeline.INDEFINITE);
        circleSpawner.play();
    }

    private Circle createCircle() {
        double random = Math.random();
        int index;
        if (random < 0.5) {
            index = 0;
        } else if (random < 0.8) {
            index = 1;
        } else {
            index = 2;
        }
        CircleInfo circleInfo = CircleInfo.values()[index];
        Circle circle = specifiedCirecle(circleInfo);

        return circle;
    }

    private Circle specifiedCirecle(CircleInfo circleInfo) {
        int r = circleInfo.getRadius();
        int x = (int) (Math.random() * (windowWidth - 2 * r));
        Circle circle = new Circle(r + x, -r, r);
        circle.setFill(circleInfo.getColor());
        addTranslateListener(circle, circleInfo);
        return circle;
    }

    private Circle positionedCirecle(CircleInfo circleInfo, double x, double y, double interval) {
        int r = circleInfo.getRadius();
        Circle circle = new Circle(x + interval, y, r);
        circle.setFill(circleInfo.getColor());
        addTranslateListener(circle, circleInfo);
        return circle;
    }

    private void addTranslateListener(Circle circle, CircleInfo circleInfo) {
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(circle.centerYProperty(), windowsHeight - circle.getRadius(), Interpolator.LINEAR);
        EventHandler onFinished = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (flag) {
                    flag = false;
                    Stage stage = new Stage();
                    stage.setTitle("Игра окончена!");
                    Group group = new Group();
                    Label label = new Label("Ваш счет: " + count);
                    label.setMinWidth(400);
                    label.setMinHeight(100);
                    label.setTextAlignment(TextAlignment.CENTER);
                    Button button = new Button("Начать заново");
                    button.setMinHeight(100);
                    button.setMinWidth(400);
                    button.setLayoutY(100);
                    button.setOnAction(event1 -> {
                        gamestage.close();
                        stage.close();
                        startGame();
                    });
                    group.getChildren().add(label);
                    group.getChildren().add(button);
                    stage.setScene(new Scene(group, 400, 200));
                    stage.show();
                    circleSpawner.stop();
                }
            }
        };

        int sp = (int) (this.speed * (windowsHeight - circle.getCenterY()) / windowsHeight);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(sp), onFinished, keyValue);

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                count++;
                info.setText("Score: " + count);
                ParallelTransition parallelTransition = new ParallelTransition();
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(disap), circle);
                fadeTransition.setFromValue(1.0f);
                fadeTransition.setToValue(0);
                parallelTransition.getChildren().add(fadeTransition);

                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(disap), circle);
                scaleTransition.setToX(1.5);
                scaleTransition.setToY(1.5);
                parallelTransition.getChildren().add(scaleTransition);

                timeline.stop();
                parallelTransition.play();
                Timeline timeline1 = new Timeline(
                        new KeyFrame(
                                Duration.millis(disap),
                                ae -> {
                                    root.getChildren().remove(circle);
                                }
                        )
                );
                timeline1.play();
                if (count > 100) {
                    speed = 2500;
                } else if (count > 50) {
                    speed = 3000;
                } else if (count > 10) {
                    speed = 4000;
                }

            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}
