package main;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Mine {
    int damage;
    int timer;
    int diameter;

    public Mine(int damage, int timer, int diameter) {
        this.damage = damage;
        this.timer = timer;
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "main.Mine{" +
                "damage=" + damage +
                ", timer=" + timer +
                ", diameter=" + diameter +
                '}';
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
