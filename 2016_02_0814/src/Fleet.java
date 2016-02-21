import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Fleet {
    ArrayList<Warship> warships;
    String name;

    public Fleet(String name, ArrayList<Warship> warships) {
        this.warships = warships;
        this.name = name;
    }

    public void fullAttackTarget(Warship warship) {
        for (Warship warship1 : warships) {
            warship1.attackShip(warship);
        }
    }

    public void fullMoveToPoint(int x, int y) {
        for (Warship warship : warships) {
            warship.moveTo(x, y);
        }
    }
}
