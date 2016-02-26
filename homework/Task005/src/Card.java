import java.io.Serializable;

/**
 * Created by Ilnyr on 27.11.2015.
 */
public class Card implements Serializable {
    private String purpose;
    private String name;
    int player_id;

    public Card(String purpose, String name, int player_id) {
        this.purpose = purpose;
        this.name = name;
        this.player_id = player_id;
    }

    public Card(String purpose, String name) {
        this.purpose = purpose;
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getName() {
        return name;
    }
}
