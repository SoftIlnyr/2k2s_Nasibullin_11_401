/**
 * Created by Ilnyr on 17.02.2016.
 */
public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this.x = 0;
        this.y = 0;

    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void add(Vector2D v) {
        this.x += v.getX();
        this.y += v.getY();
    }
}
