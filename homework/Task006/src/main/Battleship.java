package main;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public interface Battleship extends Warship {
    void addBigGun(BigGun bigGun);

    void shootBigTarget(Warship warship);

    void shootBigPoint(int x, int y);
}
