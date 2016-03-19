package main;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Plane {
    private String name;
    private int hp;
    private int viewDistance;
    private int damage;

    public Plane(String name, int hp, int viewDistance, int damage) {
        this.name = name;
        this.hp = hp;
        this.viewDistance = viewDistance;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "main.Plane{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", viewDistance=" + viewDistance +
                ", damage=" + damage +
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

    public int getViewDistance() {
        return viewDistance;
    }

    public void setViewDistance(int viewDistance) {
        this.viewDistance = viewDistance;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
