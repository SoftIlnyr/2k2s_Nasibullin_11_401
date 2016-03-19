package main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Ilnyr on 12.02.2016.
 */
@Component
public class BigGun {
    private int caliber;
    private int damage;
    private int weight;

    public BigGun() {
        this.caliber = 200;
        this.damage = 800;
        this.weight = 500;
    }

    public BigGun(int caliber, int damage, int weight) {
        this.caliber = caliber;
        this.damage = damage;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "main.BigGun{" +
                "caliber=" + caliber +
                ", damage=" + damage +
                ", weight=" + weight +
                '}';
    }

    public int getCaliber() {
        return caliber;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
