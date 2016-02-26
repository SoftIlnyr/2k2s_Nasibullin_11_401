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
        return "Mine{" +
                "damage=" + damage +
                ", timer=" + timer +
                ", diameter=" + diameter +
                '}';
    }
}
