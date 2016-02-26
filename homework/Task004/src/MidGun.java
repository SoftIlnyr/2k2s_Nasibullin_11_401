/**
 * Created by Ilnyr on 12.02.2016.
 */
public class MidGun {
    private int caliber;
    private int damage;
    private int range;

    public MidGun(int caliber, int damage, int range) {
        this.caliber = caliber;
        this.damage = damage;
        this.range = range;
    }

    @Override
    public String toString() {
        return "MidGun{" +
                "caliber=" + caliber +
                ", damage=" + damage +
                ", range=" + range +
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
