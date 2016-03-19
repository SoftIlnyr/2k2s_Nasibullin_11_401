package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilnyr on 12.02.2016.
 */
@Component
public class Nautilus implements Submarine {
    private String name;
    private List<Mine> mines;
    private int hp;
    private int speed;

    public Nautilus() {
        this.name = "Nautilus";
        this.mines = new ArrayList<>();
        this.hp = 1000;
        this.speed = 100;
    }

    public Nautilus(String name, List<Mine> mines, int hp, int speed) {
        this.name = name;
        this.mines = mines;
        this.hp = hp;
        this.speed = speed;
    }

    @Override
    public void addMine(Mine mine) {
        mines.add(mine);
        System.out.println(this.name + " picks a mine");
    }

    @Override
    public void diveDepth(int x) {
        System.out.println(this.name + " dives to " + x);
    }

    @Override
    public void dropMineAndMoveTo(int x, int y) {
        System.out.println(this.name + " drops a mine and goes to " + x + ":" + y);
    }

    @Override
    public void moveTo(int x, int y) {
        System.out.println(this.name + " moves to " + x + ":" + y);

    }

    @Override
    public void attackShip(Warship warship) {
        System.out.println(this.name + " can't attack a ship!");
    }

    @Override
    public void attackPoint(int x, int y) {
        moveTo(x, y);
        dropMineAndMoveTo(x * (-1), y * (-1));
    }

    @Override
    public String toString() {
        return "main.Nautilus{" +
                "name='" + name + '\'' +
                ", mines=" + mines +
                ", hp=" + hp +
                ", speed=" + speed +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Mine> getMines() {
        return mines;
    }

    public void setMines(ArrayList<Mine> mines) {
        this.mines = mines;
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
}
