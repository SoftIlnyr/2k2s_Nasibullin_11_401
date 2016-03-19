package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilnyr on 12.02.2016.
 */
@Component
public class QueenAnnVengeance implements Battleship {
    private String name;
    private int hp;
    private List<BigGun> bigGuns;

    public QueenAnnVengeance() {
        this.name = "qav";
        this.hp = 666;
        this.bigGuns = new ArrayList<>();
    }

    public QueenAnnVengeance(String name, int hp, List<BigGun> bigGuns) {
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
        return "main.QueenAnnVengeance{" +
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

    public List<BigGun> getBigGuns() {
        return bigGuns;
    }

    public void setBigGuns(ArrayList<BigGun> bigGuns) {
        this.bigGuns = bigGuns;
    }
}
