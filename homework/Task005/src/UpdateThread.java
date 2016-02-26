import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Ilnyr on 27.11.2015.
 */
public class UpdateThread extends Thread {
    private GameWindow window;
    private ObjectInputStream ois;

    public UpdateThread(GameWindow window, ObjectInputStream ois) {
        this.window = window;
        this.ois = ois;
    }

    @Override
    public void run() {
        Color light_blue = new Color(170, 228, 211);
        while (true) {
            try {
                Object object = ois.readObject();
                System.out.println(object.getClass().getCanonicalName());
                if (object.getClass().getCanonicalName().equals("Card")) {
                    Card card = (Card) object;
                    //System.out.println(card.getPurpose());
                    String cardName = card.getName();
                    if (cardName.length() > 0) {
                        switch (card.getPurpose()) {
                            case "actual":
                                window.setActualCard(card.getName());
                                window.actualPlayer = card.player_id;
                                for (int i = 0; i < window.playerPanels.length; i++) {
                                    JPanel panel = window.playerPanels[i];
                                    panel.setBackground(null);
                                    if (window.actualPlayer == i) {
                                        panel.setBackground(Color.WHITE);
                                    } else {
                                        panel.setBackground(light_blue);
                                    }
                                }

                                break;
                            case "add":
                                if (!cardName.equals("error")) {
                                    window.giveCard(card.getName());
                                } else {
                                    JOptionPane.showMessageDialog(null, "В колоде больше нет карт!");
                                }
                                break;
                        }
                    }
                } else if (object.getClass().getCanonicalName().equals("Player")) {
                    Player player = (Player) object;
                    JLabel label = window.playerLabels[player.id];
                    JPanel panel = window.playerPanels[player.id];
                    String info = "<html>" + player.toString();
                    //label.setText(player.toString());
                    if (player.getStatus() != null) {
                        switch (player.getStatus()) {
                            case "taketwo":
                                //label.setText(label.getText() + "takes two cards and skips a turn!");
                                info += "<br>берет 2 карты!";
                                panel.setBackground(null);
                                panel.setBackground(Color.ORANGE);
                                break;
                            case "skip":
                                //label.setText(label.getText() + "\nskips a turn!");
                                info += "<br>пропускает ход!";
                                break;
                            case "take 4":
                                //label.setText(label.getText() + "\ntakes four cards \nand skips a turn!");
                                info += "<br>берет 4 карты!";
                                panel.setBackground(null);
                                panel.setBackground(Color.ORANGE);
                                break;
                            case "uno":
                                info += "<br>не сказал UNO!";
                                panel.setBackground(null);
                                panel.setBackground(Color.ORANGE);
                                break;
                            case "saiduno":
                                info += "<br>UNO!";
                                panel.setBackground(null);
                                panel.setBackground(Color.GREEN);
                                break;
                            case "take":
                                info += "<br>берет карту...";
                                break;
                            case "intercept":
                                info += "<br>перехватил ход!";
                                break;
                        }

                    } else {
                        if (panel.getBackground() != Color.white) {
                            panel.setBackground(null);
                            panel.setBackground(light_blue);
                        }
                    }
                    info += "</html>";
                    label.setText(info);
                } else {
                    Object[] options1 = {"New game",
                            "Exit"};
                    int input = JOptionPane.showOptionDialog(null,
                            (String) object,
                            "Game over",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            options1,
                            null);
                    if (input == 0) {
                        window.dispose();
                        window.oos.close();
                        window.ois.close();
                        new ClientForm(window.address, window.me.name).setVisible(true);
                    } else {
                        window.dispose();
                        break;
                    }
                }
            } catch (EOFException e) {
                try {
                    JOptionPane.showMessageDialog(null, "Соединение прервано. Кто-то лажает!");
                    window.dispose();
                    window.oos.close();
                    window.ois.close();
                    new ClientForm(window.address, window.me.name).setVisible(true);
                    break;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
