import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Ilnyr on 30.11.2015.
 */
public class PlayersThread extends Thread {
    protected Server server;
    protected ServerSocket sc;

    public PlayersThread(Server server) throws IOException {
        this.server = server;
        this.sc = new ServerSocket(server.PORT);

    }

    @Override
    public void run() {
        try {
            while (!this.isInterrupted() && server.getConnections().size() <= 10) {
                Socket client = sc.accept();
                Connection connection = new Connection(server, client, server.getConnections().size());
                String playerName = (String) connection.ois.readObject();
                Player player = new Player(playerName, server.getConnections().size());
                int number = server.getConnections().size() + 1;
                server.getPlayers().add(player);
                showPlayers();
                server.getConnections().add(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            this.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showPlayers() {
        String res = "";
        int i = 0;
        for (Player player : server.players) {
            res += i + ") " + player.name + "\n";
            i++;
        }
        server.form.PlayersWindow.setText(res);
    }
}
