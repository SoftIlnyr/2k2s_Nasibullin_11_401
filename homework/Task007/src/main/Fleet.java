package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilnyr on 12.02.2016.
 */
@Component
public class Fleet {
    private List<Warship> warships;
    private String name;

    public Fleet() {
        this.name = "fleet";
        this.warships = new ArrayList<>();
    }

    public Fleet(String name, List<Warship> warships) {
        this.warships = warships;
        this.name = name;
    }

    public void addWarship(Warship warship) {
        this.warships.add(warship);
        System.out.println(name + ": main.Warship added!");
    }

    public void fullAttackTarget(Warship warship) {
        for (Warship warship1 : warships) {
            warship1.attackShip(warship);
        }
    }

    public void fullMoveToPoint(int x, int y) {
        for (Warship warship : warships) {
            warship.moveTo(x, y);
        }
    }

    @Override
    public String toString() {
        return "main.Fleet{" +
                "warships=" + warships +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Warship> getWarships() {
        return warships;
    }

    public void setWarships(ArrayList<Warship> warships) {
        this.warships = warships;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
