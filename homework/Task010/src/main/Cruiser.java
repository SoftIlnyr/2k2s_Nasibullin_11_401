package main;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public interface Cruiser extends Warship {
    void addMidGun(MidGun midGun);

    void shootMidTarget(Warship warship);

    void shootMidPoint(int x, int y);
}
