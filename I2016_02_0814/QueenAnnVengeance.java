package I2016_02_0814;

import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class QueenAnnVengeance implements Battleship {
    String name;
    int hp;
    ArrayList<BigGun> bigGuns;

    public QueenAnnVengeance(String name, int hp, ArrayList<BigGun> bigGuns) {
        this.name = name;
        this.hp = hp;
        this.bigGuns = bigGuns;
    }

    @Override
    public void addBigGun(BigGun bigGun) {
        bigGuns.add(bigGun);
        System.out.println("QAV adds a big gun!");

    }

    @Override
    public void shootBigTarget(Warship warship) {
        System.out.println("QAV shoots at warship with a big BOOM!");
    }

    @Override
    public void shootBigPoint(int x, int y) {
        System.out.println("QAV shoots to the point " + x + ":" + y);
    }

    @Override
    public void moveTo(int x, int y) {
        System.out.println("QAV moves to the point " + x +":" + y);
    }

    @Override
    public void attackShip(Warship warship) {
        shootBigTarget(warship);
    }

    @Override
    public void attackPoint(int x, int y) {
        shootBigPoint(x, y);
    }
}
