package main;

import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Destroyer implements TorpedoBoat, Scout {
    private String name;
    private int hp;
    private int speed;
    private ArrayList<Torpedo> torpedos;

    public Destroyer(String name, int hp, int speed) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.torpedos = new ArrayList<Torpedo>();
    }

    @Override
    public void scoutPoint(int x, int y) {
        System.out.println("main.Destroyer moves to the point " + x + ":" + y);
    }

    @Override
    public void boarding(Warship warship) {
        System.out.println("main.Destroyer attacks tagged ship");
    }

    @Override
    public void smoke() {
        System.out.println("main.Destroyer makes a big smoke veil. No main.Warship can see at the 5 km distance!");
    }

    @Override
    public void addTorpedo(Torpedo torpedo) {
        this.torpedos.add(torpedo);
        System.out.println("Destoyer picked a torpedo");
    }

    @Override
    public void launchTorpedoAngle(int x) {
        System.out.println("main.Destroyer launched all torpedoes to the angle " + x);
        int s = 0;
        for (Torpedo torpedo : torpedos) {
            s = s > torpedo.getRange() ? s : torpedo.getRange();
        }
        System.out.println("...they fly max to the " + s + " kilometers");
    }

    @Override
    public void launchTorpedoTarget(Warship warship) {
        System.out.println("main.Destroyer launched all torpedoes to the target ");
        int s = 0;
        for (Torpedo torpedo : torpedos) {
            s += torpedo.getDamage();
        }
        System.out.println("...and damages " + s + " hp");
    }

    @Override
    public void moveTo(int x, int y) {
        System.out.println("main.Destroyer moves to the " + x + ":" + y);
    }

    @Override
    public void attackShip(Warship warship) {
        launchTorpedoTarget(warship);

    }

    @Override
    public void attackPoint(int x, int y) {
        launchTorpedoAngle(x / y);
    }

    @Override
    public String toString() {
        return "main.Destroyer{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", speed=" + speed +
                ", torpedos=" + torpedos +
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Torpedo> getTorpedos() {
        return torpedos;
    }

    public void setTorpedos(ArrayList<Torpedo> torpedos) {
        this.torpedos = torpedos;
    }
}
