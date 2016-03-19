package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilnyr on 12.02.2016.
 */
@Component
public class Jackdaw implements Cruiser, Scout {
    private String name;
    private int hp;
    private List<MidGun> midGuns;

    public Jackdaw() {
        this.name = "jackdaw";
        this.hp = 1500;
        this.midGuns = new ArrayList<>();
    }

    public Jackdaw(String name, int hp, List<MidGun> midGuns) {
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
        System.out.println(name + " scouts point " + x + ":" + y);

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

    @Override
    public String toString() {
        return "main.Jackdaw{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", midGuns=" + midGuns +
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

    public List<MidGun> getMidGuns() {
        return midGuns;
    }

    public void setMidGuns(ArrayList<MidGun> midGuns) {
        this.midGuns = midGuns;
    }
}
