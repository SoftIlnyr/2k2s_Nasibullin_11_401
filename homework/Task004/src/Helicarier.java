import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Helicarier implements Aircraft {
    private String name;
    private int hp;
    private ArrayList<Plane> planes;

    public Helicarier(String name, int hp, ArrayList<Plane> planes ) {
        this.planes = planes;
        this.name = name;
        this.hp = hp;
    }

    @Override
    public void addPlane(Plane plane) {
        planes.add(plane);
        System.out.println("Helicarier picks a plane");
    }

    @Override
    public void planeToVenture(int x, int y) {
        System.out.println("Helicarier sends a plane to the point " + x + ":" + y);
    }

    @Override
    public void planeAttackTarget(Warship warship) {
        System.out.println("Helicarier sends all planes to attack warship");
    }

    @Override
    public void moveTo(int x, int y) {
        System.out.println("Helicarier moves to point " + x + ":" + y);
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
        return "Helicarier{" +
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

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<Plane> planes) {
        this.planes = planes;
    }
}
