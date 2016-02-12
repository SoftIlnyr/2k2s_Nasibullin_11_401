package I2016_02_0814;

import java.util.ArrayList;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public class Nautilus implements Submarine {
    String name;
    ArrayList<Mine> mines;
    int hp;
    int speed;

    public Nautilus(String name, ArrayList<Mine> mines, int hp, int speed) {
        this.name = name;
        this.mines = mines;
        this.hp = hp;
        this.speed = speed;
    }

    @Override
    public void addMine(Mine mine) {
        mines.add(mine);
        System.out.println("Nautilus picks a mine");
    }

    @Override
    public void diveDepth(int x) {
        System.out.println("Nautilus dives to " + x);
    }

    @Override
    public void dropMineAndMoveTo(int x, int y) {
        System.out.println("Nautilus drops a mine and goes to " + x + ":" + y);
    }

    @Override
    public void moveTo(int x, int y) {
        System.out.println("Nautilus moves to " + x + ":" + y);

    }

    @Override
    public void attackShip(Warship warship) {
        System.out.println("Nautilus can't attack a ship!");
    }

    @Override
    public void attackPoint(int x, int y) {
        moveTo(x, y);
        dropMineAndMoveTo(x * (-1), y * (-1));
    }
}
