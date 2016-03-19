import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * Created by Ilnyr on 25.11.2015.
 */
public class Connection implements Runnable {
    Socket socket;
    Server server;
    Thread thread;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    int id;

    public Connection(Server server, Socket socket, int id) throws IOException {
        this.socket = socket;
        this.server = server;
        this.id = id;
        this.ois = new ObjectInputStream(this.socket.getInputStream());
        this.oos = new ObjectOutputStream(this.socket.getOutputStream());
        this.oos.flush();
        thread = new Thread(this);
    }

    @Override
    public void run() {
        //System.out.println("Connection at work!");
        try {
            oos.writeObject(server.players.get(this.id));
            oos.writeObject(server.getPlayers());
            firstHand();
            System.out.println("Cards are given!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(server.players.toString());
        while (true) {
            try {
                Card card = (Card) ois.readObject();
                switch (card.getPurpose()) {
                    case "actual":
                        Player player = server.players.get(this.id);
                        if (this.id != server.actualPlayer) {
                            player.setStatus("intercept");
                        } else {
                            player.setStatus(null);
                        }
                        notifyOthers(player);
                        if (!card.getName().equals("skip")) {
                            server.setActualCard(card.getName());
                            String actCard = server.getActualCard();
                            if (actCard.contains("reverse")) {
                                server.step *= -1;
                            }
                            server.actualPlayer = server.nextPlayer(this.id);
                            player = server.players.get(server.actualPlayer);
                            server.players.get(this.id).cards--;
                            checkWinner(server.players.get(this.id));
                            if (actCard.contains("taketwo")) {
                                Connection connection = server.getConnections().get(server.actualPlayer);
                                for (int k = 0; k < 2; k++) {
                                    String cardName = server.getRandomCard();
                                    Card resp = new Card("add", cardName);
                                    connection.oos.writeObject(resp);
                                    player.cards++;
                                }
                                player.setStatus("taketwo");
                                notifyOthers(player);
                                server.actualPlayer = server.nextPlayer(server.actualPlayer);
                            }
                            if (actCard.contains("skip")) {
                                player.setStatus("skip");
                                notifyOthers(player);
                                server.actualPlayer = server.nextPlayer(server.actualPlayer);
                                //player.setStatus("skip");
                                //server.actualPlayer = server.nextPlayer(server.actualPlayer);
                            }
                            if (actCard.contains("take 4")) {
                                Connection connection = server.getConnections().get(server.actualPlayer);
                                for (int k = 0; k < 4; k++) {
                                    String cardName = server.getRandomCard();
                                    Card resp = new Card("add", cardName);
                                    connection.oos.writeObject(resp);
                                    player.cards++;
                                }
                                player.setStatus("take 4");
                                notifyOthers(player);
                                server.actualPlayer = server.nextPlayer(server.actualPlayer);
                            }
                            player.setStatus(null);
                        } else if (card.getName().equals("skip")) {
                            server.players.get(server.actualPlayer).setStatus("skip");
                            notifyOthers(server.players.get(server.actualPlayer));
                            server.actualPlayer = server.nextPlayer(server.actualPlayer);
                        }
                        System.out.println(server.actualPlayer);
                        Card resp = new Card("actual", server.getActualCard(), server.actualPlayer);
                        player = server.players.get(this.id);
                        checkUno(player);
                        for (Connection connection : server.getConnections()) {
                            connection.oos.writeObject(player);
                            connection.oos.writeObject(resp);
                        }
                        break;
                    case "add":
                        String cardName = server.getRandomCard();
                        Player update = server.players.get(this.id);
                        resp = new Card("add", cardName);
                        update.cards++;
                        oos.writeObject(resp);
                        update.setStatus("take");
                        notifyOthers(update);
                        break;
                    case "uno":
                        if (card.getName().equals("say")) {
                            Player p = server.players.get(this.id);
                            p.saidUNO = true;
                            p.setStatus("saiduno");
                            notifyOthers(p);
                        } else if (card.getName().equals("find")) {
                            for (Player p : server.players) {
                                if (p.cards == 1 && !p.saidUNO) {
                                    Connection connection = server.connections.get(p.id);
                                    for (int k = 0; k < 2; k++) {
                                        cardName = server.getRandomCard();
                                        resp = new Card("add", cardName);
                                        connection.oos.writeObject(resp);
                                        p.cards++;
                                    }
                                    p.setStatus("uno");
                                    notifyOthers(p);
                                }
                            }
                        }
                }
                System.out.println(server.players.toString() + " " + server.players.get(this.id));
                notifyOthers(server.getPlayers().get(this.id));
            } catch (SocketException e) {
                try {
                    server.newGame();
                    break;
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkUno(Player player) {
        if (player.cards > 1) {
            player.saidUNO = false;
        }
    }

    private void checkWinner(Player player) throws IOException, ClassNotFoundException, InterruptedException {
        if (player.cards == 0) {
            String message = player.name + " wins!";
            for (Connection connection : server.getConnections()) {
                connection.oos.writeObject(message);
            }
            server.newGame();
        }
    }

    private void notifyOthers(Player player) throws IOException {
        for (Connection connection : server.connections) {
            connection.oos.reset();
            connection.oos.writeObject(player);
        }
    }

    private void firstHand() throws IOException {
        oos.writeObject(server.getActualCard());
        ArrayList<String> playerCards = new ArrayList<>();
        for (int i = 0; i < server.FIRST_HAND; i++) {
            String card = server.getRandomCard();
            playerCards.add(card);
            server.players.get(this.id).cards++;
        }
        oos.writeObject(playerCards);
    }
}
