/**
 * Created by Ilnyr on 12.02.2016.
 */
public interface Warship {
    void moveTo(int x, int y);

    void attackShip(Warship warship);

    void attackPoint(int x, int y);
}
