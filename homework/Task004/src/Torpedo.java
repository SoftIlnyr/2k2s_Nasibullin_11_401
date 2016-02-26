/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Torpedo {
    private String type;
    private int damage;
    private int range;

    public Torpedo(String type, int damage, int range) {
        this.type = type;
        this.damage = damage;
        this.range = range;
    }

    @Override
    public String toString() {
        return "Torpedo{" +
                "type='" + type + '\'' +
                ", damage=" + damage +
                ", range=" + range +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
