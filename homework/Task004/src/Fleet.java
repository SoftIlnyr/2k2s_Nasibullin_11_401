import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Fleet {
    private ArrayList<Warship> warships;
    private String name;

    public Fleet(String name, ArrayList<Warship> warships) {
        this.warships = warships;
        this.name = name;
    }

    public void addWarship(Warship warship) {
        this.warships.add(warship);
        System.out.println(name + ": Warship added!");
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

    @Override
    public String toString() {
        return "Fleet{" +
                "warships=" + warships +
                ", name='" + name + '\'' +
                '}';
    }

    public ArrayList<Warship> getWarships() {
        return warships;
    }

    public void setWarships(ArrayList<Warship> warships) {
        this.warships = warships;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
