package I2016_02_0814;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public interface Submarine extends Warship {
    void addMine(Mine mine);

    void diveDepth(int x);

    void dropMineAndMoveTo(int x, int y);
}
