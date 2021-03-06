import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class EpicMachine implements Scout, Battleship {
    String name;
    int hp;
    ArrayList<BigGun> bigGuns;

    public EpicMachine(String name, int hp, ArrayList<BigGun> bigGuns) {
        this.name = name;
        this.hp = hp;
        this.bigGuns = bigGuns;
    }

    @Override
    public void addBigGun(BigGun bigGun) {
        bigGuns.add(bigGun);
        System.out.println(name + " picks a bigGun!");
    }

    @Override
    public void shootBigTarget(Warship warship) {
        System.out.println(name + " shoots a warship with a VERY BIG GUN!");
    }

    @Override
    public void shootBigPoint(int x, int y) {
        System.out.println(name + " shoots to the point with a VERY BIG GUN!" );
    }

    @Override
    public void scoutPoint(int x, int y) {
        System.out.println(name + "is to gourgeous to scout!");

    }

    @Override
    public void boarding(Warship warship) {
        System.out.println(name + "rams an enemy warship!");

    }

    @Override
    public void smoke() {
        System.out.println(name + "produces smoke! Nobody can see!");
    }

    @Override
    public void moveTo(int x, int y) {
        System.out.println(name + "moves to point " + x + ":" + y);

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
