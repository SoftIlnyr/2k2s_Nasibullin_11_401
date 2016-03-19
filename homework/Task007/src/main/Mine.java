package main;

import org.springframework.stereotype.Component;

/**
 * Created by Ilnyr on 12.02.2016.
 */
@Component
public class Mine {
    int damage;
    int timer;
    int diameter;

    public Mine() {
        this.damage = 1000;
        this.timer = 60;
        this.diameter = 1;
    }

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
}
