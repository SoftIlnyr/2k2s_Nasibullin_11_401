package main;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Helicarier implements Aircraft {
    private String name;
    private int hp;
    @Autowired
    private List<Plane> planes;

    public Helicarier(String name, int hp, List<Plane> planes ) {
        this.planes = planes;
        this.name = name;
        this.hp = hp;
    }

    @Override
    public void addPlane(Plane plane) {
        planes.add(plane);
        System.out.println("main.Helicarier picks a plane");
    }

    @Override
    public void planeToVenture(int x, int y) {
        System.out.println("main.Helicarier sends a plane to the point " + x + ":" + y);
    }

    @Override
    public void planeAttackTarget(Warship warship) {
        System.out.println("main.Helicarier sends all planes to attack warship");
    }

    @Override
    public void moveTo(int x, int y) {
        System.out.println("main.Helicarier moves to point " + x + ":" + y);
    }

    @Override
    public void attackShip(Warship warship) {
        planeAttackTarget(warship);
    }

    @Override
    public void attackPoint(int x, int y) {
        planeToVenture(x, y);
    }

    @Override
    public String toString() {
        return "main.Helicarier{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", planes=" + planes +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<Plane> planes) {
        this.planes = planes;
    }
}
