import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class QueenAnnVengeance implements Battleship {
    private String name;
    private int hp;
    private ArrayList<BigGun> bigGuns;

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

    @Override
    public String toString() {
        return "QueenAnnVengeance{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", bigGuns=" + bigGuns +
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

    public ArrayList<BigGun> getBigGuns() {
        return bigGuns;
    }

    public void setBigGuns(ArrayList<BigGun> bigGuns) {
        this.bigGuns = bigGuns;
    }
}
