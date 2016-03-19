import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ilnyr on 22.11.2015.
 */
public class GameWindow extends JFrame {
    ArrayList<String> playerCards; //карты игрока
    ArrayList<JButton> showingCards; //карты, отображаемые в userPanel
    JPanel gamePanel = new JPanel(new BorderLayout()); //панель с активной картой
    JPanel userPanel = new JPanel(new BorderLayout()); //панель карт игрока
    JButton actualCard; //актуальная карта
    JButton deckCard; //взять карту
    ObjectInputStream ois;
    ObjectOutputStream oos;
    int first_card; //первая показываемая карты
    final int FIRST_HAND = 7; //количество карт, раздаваемых в начале игры
    int actualPlayer;
    Player me;
    JPanel[] playerPanels;
    JLabel[] playerLabels;
    boolean tookDeckCard;
    boolean saidUNO;
    String address;

    public GameWindow(ObjectInputStream ois, ObjectOutputStream oos, Player player, String address) throws IOException, ClassNotFoundException {
        this.ois = ois;
        this.oos = oos;
        this.me = player;
        this.address = address;
        this.oos.flush();
        this.playerCards = new ArrayList<>();
        this.tookDeckCard = false;
        this.saidUNO = false;
        initComponents();
    }

    private void initComponents() throws IOException, ClassNotFoundException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1024, 768));
        setMinimumSize(new Dimension(1024, 768));
        setPreferredSize(new Dimension(1024, 768));

        gamePanel.setBounds(0, 0, 1024, 568);
        Color light_blue = new Color(170, 228, 211);
        gamePanel.setBackground(light_blue);
        JPanel[] gamePanels = new JPanel[3];
        gamePanel.setLayout(new GridLayout(1, 3));
        for (int i = 0; i < 3; i++) {
            gamePanels[i] = new JPanel();
            gamePanels[i].setBackground(light_blue);
            gamePanel.add(gamePanels[i]);
        }


        ArrayList<Player> players = (ArrayList<Player>) ois.readObject();
        playerPanels = new JPanel[players.size()];
        playerLabels = new JLabel[players.size()];
        gamePanels[0].setLayout(new GridLayout(players.size(), 1));
        for (int i = 0; i < players.size(); i++) {
            playerPanels[i] = new JPanel();
            playerPanels[i].setBackground(light_blue);
            JLabel PLabel = new JLabel(players.get(i).toString());
            PLabel.setFont(new Font(PLabel.getFont().getName(), Font.PLAIN, 24));
            PLabel.setVerticalAlignment(SwingConstants.CENTER);
            PLabel.setHorizontalAlignment(SwingConstants.LEFT);
            playerPanels[i].add(PLabel);
            playerLabels[i] = PLabel;
            gamePanels[0].add(playerPanels[i]);
        }

        playerPanels[0].setBackground(null);
        playerPanels[0].setBackground(Color.white);

        actualCard = new JButton();
        actualCard.setBorder(BorderFactory.createEmptyBorder());
        actualCard.setContentAreaFilled(false);
        String ac = (String) ois.readObject();
        setActualCard(ac);

        gamePanels[1].add(actualCard);

        //skip button
        JButton skipButton = new JButton();
        skipButton.setPreferredSize(new Dimension(200, 100));
        skipButton.setText("Пропустить ход");
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (actualPlayer == me.id) {
                    if (tookDeckCard) {
                        try {
                            oos.writeObject(new Card("actual", "skip", me.id));
                            tookDeckCard = false;
                            checkUNO();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Возьмите карту!");
                    }
                }
            }
        });

        gamePanels[1].add(skipButton);

        setDeckCard(); //карта колоды - берем нужные карты
        gamePanels[2].add(deckCard);

        //uno button

        JButton unoButton = new JButton();
        unoButton.setPreferredSize(new Dimension(200, 100));
        unoButton.setText("UNO");
        unoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerCards.size() <= 2 && !saidUNO) {
                    saidUNO = true;
                    /*
                    try {
                        oos.writeObject(new Card("uno", "say"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }*/
                } else {
                    try {
                        oos.writeObject(new Card("uno", "find"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        gamePanels[2].add(unoButton);
        add(gamePanel);

        userPanel.setBounds(0, 608, 1024, 200);
        userPanel.setBackground(light_blue);
        add(userPanel, BorderLayout.SOUTH);


        //firstHand();
        playerCards = (ArrayList<String>) ois.readObject();
        Collections.sort(playerCards);
        userPanel.setLayout(new GridLayout(1, 9));
        showPrevCard();
        showPlayerCards();
        showNextCard();

        setTitle(me.name);

        setVisible(true);

        UpdateThread thread = new UpdateThread(this, ois);
        thread.start();
    }

    private void showNextCard() {
        JButton jb = new JButton("След. Карты");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int step = 0;
                while (step < 3 && first_card + step + FIRST_HAND < playerCards.size()) {
                    step++;
                }
                first_card += step;
                try {
                    showPlayerCards();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        userPanel.add(jb);
    }

    private void showPrevCard() {
        JButton jb = new JButton("Пред. Карты");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int step = 0;
                while (step < 3 && first_card - step - 1 >= 0) {
                    step++;
                }
                first_card -= step;
                try {
                    showPlayerCards();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        userPanel.add(jb);
    }

    protected void setActualCard(String s) throws IOException {
        actualCard.setToolTipText(s);
        actualCard.setIcon(CardDeck.getCardIcons().get(s));
    }

    private void setDeckCard() throws IOException {
        deckCard = new JButton();
        deckCard.setToolTipText("back");
        deckCard.setIcon(CardDeck.getCardIcons().get("back"));
        deckCard.setBorder(BorderFactory.createEmptyBorder());
        deckCard.setContentAreaFilled(false);
        deckCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (actualPlayer == me.id) {
                        if (!tookDeckCard) {
                            if (!checkPlayerCards()) {
                                oos.writeObject(new Card("add", ""));
                                oos.flush();
                                tookDeckCard = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "У Вас есть подходящая карта!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Вы уже брали карту");
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //JOptionPane.showMessageDialog(null, "There are no cards in the deck!");

            }
        });
    }

    private boolean checkPlayerCards() {
        boolean flag = false;
        for (String card : playerCards) {
            if (!card.contains("zorder")) {
                flag = checkCard(card) >= 0;
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }


    private void showPlayerCards() throws IOException {
        if (showingCards == null) {
            //BufferedImage sourceImage = ImageIO.read(new File("cards/back.png"));
            ImageIcon sourceImage = CardDeck.getCardIcons().get("back");
            //Image thumbnail = sourceImage.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            Image thumbnail = sourceImage.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            showingCards = new ArrayList<JButton>();
            for (int i = 0; i < FIRST_HAND; i++) {
                final JButton button = new JButton();
                button.setBorder(BorderFactory.createEmptyBorder());
                button.setContentAreaFilled(false);
                button.setIcon(new ImageIcon(thumbnail));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String card = button.getToolTipText();
                        if (actualPlayer == me.id) {
                            int input = checkCard(card);
                            if (input >= 0) {
                                try {
                                    String extra = "";
                                    if (input >= 0 && input <= 4) {
                                        Object[] options1 = {"red",
                                                "yellow",
                                                "green", "blue"};
                                        extra = " " + options1[input];
                                    }
                                    oos.writeObject(new Card("actual", card + extra, me.id));
                                    playerCards.remove(card);
                                    tookDeckCard = false;
                                    showPlayerCards();
                                    checkUNO();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        } else {
                            if (card.equals(actualCard.getToolTipText())) {
                                try {
                                    oos.writeObject(new Card("actual", card, me.id));
                                    playerCards.remove(card);
                                    showPlayerCards();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }
                    }
                });
                showingCards.add(button);
                userPanel.add(button);
            }
        }
        int show_count = playerCards.size() < FIRST_HAND ? playerCards.size() : FIRST_HAND;
        if (show_count == 7 && playerCards.size() < first_card + show_count) {
            first_card--;
            showPlayerCards();
        } else {
            for (int i = 0; i < show_count; i++) {
                JButton button = showingCards.get(i);
                String cardName = playerCards.get(first_card + i);
                button.setToolTipText(cardName);
                Image thumbnail = CardDeck.getCardIcons().get(cardName).getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(thumbnail));
                button.setVisible(true);
            }
            if (show_count < FIRST_HAND) {
                for (int i = show_count; i < FIRST_HAND; i++) {
                    showingCards.get(i).setVisible(false);
                }
            }
        }
        Collections.sort(playerCards);
    }

    private void checkUNO() {
        if (playerCards.size() > 1) {
            saidUNO = false;
        } else {
            if (saidUNO) {
                try {
                    oos.writeObject(new Card("uno", "say"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private int checkCard(String info) {
        String[] cardAtr = info.split(" ");
        if (cardAtr.length == 2) {
            String actualCard = this.actualCard.getToolTipText();
            if (!actualCard.contains("zorder")) {
                if (actualCard.contains(cardAtr[0]) || actualCard.contains(cardAtr[1])) {
                    return 5;
                }
            } else {
                if (actualCard.contains(cardAtr[0])) {
                    return 5;
                }
            }
        } else if (cardAtr[0].equals("zorder")) {
            Object[] options1 = {"red",
                    "yellow",
                    "green", "blue"};
            int input = JOptionPane.showOptionDialog(null,
                    "Order a color",
                    "Choose a color",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options1,
                    null);
            if (input >= 0) {
                return input;
            }
        }
        return -1;
    }

    protected boolean giveCard(String card) throws IOException {
        playerCards.add(0, card);
        first_card = 0;
        showPlayerCards();
        return true;
    }

    /*
    private void firstHand() {
        playerCards = new ArrayList<String>();
        int count = 0;
        while (count < FIRST_HAND) {
            if (giveCard()) {
                count++;
            }
        }
    }*/


}
