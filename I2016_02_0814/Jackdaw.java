package I2016_02_0814;

import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Jackdaw implements Cruiser, Scout {
    String name;
    int hp;
    ArrayList<MidGun> midGuns;

    public Jackdaw(String name, int hp, ArrayList<MidGun> midGuns) {
        this.name = name;
        this.hp = hp;
        this.midGuns = midGuns;
    }

    @Override
    public void addMidGun(MidGun midGun) {
        midGuns.add(midGun);
        System.out.println(name + " adds a midgun");
    }

    @Override
    public void shootMidTarget(Warship warship) {
        System.out.println(name + " shoots to the warship");
    }

    @Override
    public void shootMidPoint(int x, int y) {
        System.out.println(name + " shoots to the point " + x + ":" + y + " with midguns");

    }

    @Override
    public void scoutPoint(int x, int y) {
        System.out.println(name + "scouts point " + x + ":" + y);

    }

    @Override
    public void boarding(Warship warship) {
        System.out.println(name + " is taking an enemy warship!");
    }

    @Override
    public void smoke() {
        System.out.println(name + " has not a smoke!");

    }

    @Override
    public void moveTo(int x, int y) {
        System.out.println(name + "flies to the point");
    }

    @Override
    public void attackShip(Warship warship) {
        shootMidTarget(warship);
    }

    @Override
    public void attackPoint(int x, int y) {
        shootMidPoint(x, y);
    }
}
