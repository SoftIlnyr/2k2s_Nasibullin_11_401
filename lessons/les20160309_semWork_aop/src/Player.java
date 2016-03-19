import java.io.Serializable;

/**
 * Created by Ilnyr on 04.12.2015.
 */
public class Player implements Serializable {
    String name;
    int cards;
    int id;
    String status;
    boolean saidUNO;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        this.cards = 0;
        this.saidUNO = false;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return (this.name + ": " + this.cards + " карт");
    }
}
