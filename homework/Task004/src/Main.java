import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Plane> planes = new ArrayList<Plane>();
        ArrayList<BigGun> bigGuns = new ArrayList<BigGun>();
        ArrayList<Mine> mines = new ArrayList<Mine>();
        ArrayList<MidGun> midGuns = new ArrayList<MidGun>();
        for (int i = 0; i < 10; i++) {
            planes.add(new Plane("Plane " + i, 1000 + 10 * i, 10000, 100 + 10 * i));
            bigGuns.add(new BigGun(i, i * 10, 1000 * i));
            mines.add(new Mine(1000, i * 10, i));
            midGuns.add(new MidGun(150, 200, 150 * i));
        }

        Warship d1 = new Destroyer("WAKATAKE", 10000, 40);
        Warship n1 = new Nautilus("Nemo", mines, 1000, 70);
        Warship e1 = new EpicMachine("Emperor", 1000000, bigGuns);
        Warship j1 = new Jackdaw("Sparrow", 5000, midGuns);
        Warship q1 = new QueenAnnVengeance("BlackBeard", 10000, bigGuns);
        Warship h1 = new Helicarier("Shield", 6000, planes);

        ArrayList<Warship> list = new ArrayList<Warship>();
        list.add(d1);
        list.add(n1);
        list.add(j1);
        list.add(q1);
        list.add(h1);

        Fleet fleet = new Fleet("Raid", list);

        fleet.fullAttackTarget(e1);
        fleet.fullMoveToPoint(10, 20);
    }
}
