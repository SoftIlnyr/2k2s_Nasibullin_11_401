package sample;

import javafx.scene.paint.Color;

/**
 * Created by softi on 14.05.2016.
 */
public enum CircleInfo {
    EASY(50, Color.GREEN, 3000), MIDDLE(30, Color.YELLOW, 3000),
//    TRIPLE(30, Color.YELLOW, 3000),
    HARD(20, Color.RED, 3000), TRICKY(30, Color.BLUE, 3000),;

    private int radius;
    private Color color;
    private int speed;

    CircleInfo(int radius, Color color, int speed) {
        this.radius = radius;
        this.color = color;
        this.speed = speed;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }
}
