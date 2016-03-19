package main;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public interface Aircraft extends Warship {
    void addPlane(Plane plane);

    void planeToVenture(int x, int y);

    void planeAttackTarget(Warship warship);
}
