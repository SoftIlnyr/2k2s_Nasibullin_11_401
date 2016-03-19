import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ilnyr on 25.11.2015.
 */
public class Server {
    ArrayList<Connection> connections;
    ArrayList<Player> players;
    ArrayList<String> unUsedCards; //неиспользованные карты
    ArrayList<String> UsedCards; //Использованные карты
    final int FIRST_HAND = 7; //количество карт, раздаваемых в начале игры
    String actualCard; //название актуальной карты
    protected ServerForm form;
    PlayersThread thread;
    int actualPlayer;
    int step;


    protected final int PORT = 3456;

    public Server() throws IOException, ClassNotFoundException, InterruptedException {
        this.unUsedCards = createUnUsedCards();
        this.UsedCards = new ArrayList<String>();
        this.actualCard = setFirstCard();
        this.players = new ArrayList<>();
        this.actualPlayer = 0;
        this.step = 1;
        connections = new ArrayList<Connection>();
        go();
    }

    private void go() throws IOException, ClassNotFoundException, InterruptedException {
        this.form = new ServerForm(this);
        this.form.setVisible(true);
        thread = new PlayersThread(this);
        thread.start();
        thread.join();
        System.out.println(connections.size());
        int count = 0;
        for (Connection connection : connections) {
            connection.oos.writeObject(players.get(count));
            connection.oos.flush();
            connection.thread.start();
            count++;
        }
    }

    private ArrayList<String> createUnUsedCards() {
        ArrayList<String> list = new ArrayList<String>();
        String[] array = Deck.getCards();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    private String setFirstCard() throws IOException {
        Random random = new Random();
        String[] array = Deck.getCards();
        String card = array[random.nextInt(unUsedCards.size())];
        unUsedCards.remove(card);
        if (card.split(" ")[0].equals("zorder")) {
            Object[] options1 = {"red",
                    "yellow",
                    "green", "blue"};
            Random color = new Random();
            card += " " + options1[color.nextInt(4)];
        }
        return card;
    }

    private boolean checkDeck() {
        if (unUsedCards.size() > 0 && unUsedCards.get(0) != null) {
            return true;
        } else if ((unUsedCards.size() == 0 || unUsedCards.get(0) == null) && UsedCards.size() > 0) {
            unUsedCards = UsedCards;
            UsedCards = new ArrayList<String>();
            return true;
        }
        return false;
    }

    public String getRandomCard() {
        boolean flag = checkDeck();
        if (flag) {
            Random random = new Random();
            String card = unUsedCards.get(random.nextInt(unUsedCards.size()));
            unUsedCards.remove(card);
            return card;
        } else {
            return "error";
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Server server = new Server();
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public String getActualCard() {
        return actualCard;
    }

    public void setActualCard(String actualCard) {
        UsedCards.add(this.actualCard);
        this.actualCard = actualCard;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }


    public int nextPlayer(int id) {
        int number = id + step;
        if (number >= connections.size()) {
            number = 0;
        }
        if (number < 0) {
            number = connections.size() - 1;
        }
        return number;
    }

    public void newGame() throws IOException, InterruptedException, ClassNotFoundException {
        for (Connection connection : connections) {
            connection.oos.close();
            connection.ois.close();
            connection.socket.close();
        }
        this.form.dispose();
        this.unUsedCards = createUnUsedCards();
        this.UsedCards = new ArrayList<String>();
        this.actualCard = setFirstCard();
        this.players = new ArrayList<>();
        this.actualPlayer = 0;
        this.step = 1;
        connections = new ArrayList<Connection>();
        go();
    }
}
