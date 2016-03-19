import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Ilnyr on 22.11.2015.
 */
public class GW extends JFrame {
    ArrayList<String> unUsedCards; //неиспользованные карты
    ArrayList<String> UsedCards; //Использованные карты
    ArrayList<String> playerCards; //карты игрока
    ArrayList<JButton> showingCards; //карты, отображаемые в userPanel
    JPanel gamePanel = new JPanel(new BorderLayout()); //панель с активной картой
    JPanel userPanel = new JPanel(new BorderLayout()); //панель карт игрока
    final int FIRST_HAND = 7; //количество карт, раздаваемых в начале игры
    int first_card; //первая показываемая карты
    JButton actualCard; //актуальная карта
    JButton deckCard; //взять карту

    public GW() throws IOException {
        initComponents();
    }

    private void initComponents() throws IOException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1024, 768));
        setMinimumSize(new Dimension(1024, 768));
        setPreferredSize(new Dimension(1024, 768));

        unUsedCards = createUnUsedCards();
        UsedCards = new ArrayList<String>();

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

        setFirstCard(); //первая карта в игре
        gamePanels[1].add(actualCard);

        setDeckCard(); //карта колоды - берем нужные карты
        gamePanels[2].add(deckCard);

        add(gamePanel);

        userPanel.setBounds(0, 608, 1024, 200);
        userPanel.setBackground(light_blue);
        add(userPanel, BorderLayout.SOUTH);
        firstHand();
        Collections.sort(playerCards);
        userPanel.setLayout(new GridLayout(1, 9));
        showPrevCard();
        showPlayerCards();
        showNextCard();

        setVisible(true);
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

    private void setFirstCard() throws IOException {
        Random random = new Random();
        String[] array = Deck.getCards();
        boolean flag = false;
        while (!flag) {
            String card = array[random.nextInt(108)];
            if (unUsedCards.contains(card)) {
                unUsedCards.remove(card);
                if (card.split(" ")[0].equals("zorder")) {
                    Object[] options1 = {"red",
                            "yellow",
                            "green", "blue"};
                    Random color = new Random();
                    card += " " + options1[color.nextInt(4)];
                }
                setActualCard(card);
                flag = true;
            }
        }
    }

    private void setDeckCard() throws IOException {
        BufferedImage sourceImage = ImageIO.read(new File("cards/back.png"));
        deckCard = new JButton();
        deckCard.setToolTipText("back");
        deckCard.setIcon(new ImageIcon(sourceImage));
        deckCard.setBorder(BorderFactory.createEmptyBorder());
        deckCard.setContentAreaFilled(false);
        deckCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unUsedCards.size() > 0 && unUsedCards.get(0) != null) {
                    giveCard();
                    try {
                        showPlayerCards();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println(unUsedCards.size());
                } else if ((!checkDeck())) {
                    JOptionPane.showMessageDialog(null, "There are no cards in the deck!");
                }

            }
        });
    }

    private boolean checkDeck() {
        if ((unUsedCards.size() == 0 || unUsedCards.get(0) == null) && UsedCards.size()>0) {
            unUsedCards = UsedCards;
            UsedCards = new ArrayList<String>();
            return true;
        }
        return false;
    }

    private void setActualCard(String s) throws IOException {
        if (actualCard == null) {
            actualCard = new JButton();
            actualCard.setBorder(BorderFactory.createEmptyBorder());
            actualCard.setContentAreaFilled(false);
        }
        UsedCards.add(actualCard.getToolTipText());
        actualCard.setToolTipText(s);
        actualCard.setIcon(Deck.getCardIcons().get(s));
    }

    private void showPlayerCards() throws IOException {
        if (showingCards == null) {
            showingCards = new ArrayList<JButton>();
            for (int i = 0; i < FIRST_HAND; i++) {
                final JButton button = new JButton();
                button.setBorder(BorderFactory.createEmptyBorder());
                button.setContentAreaFilled(false);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String card = button.getToolTipText();
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
                                setActualCard(card + extra);
                                playerCards.remove(card);
                                showPlayerCards();
                            } catch (IOException e1) {
                                e1.printStackTrace();
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
                Image thumbnail = Deck.getCardIcons().get(cardName).getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
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

    private int checkCard(String info) {
        String[] cardAtr = info.split(" ");
        if (cardAtr.length == 2) {
            String actualCard = this.actualCard.getToolTipText();
            if (actualCard.contains(cardAtr[0]) || actualCard.contains(cardAtr[1])) {
                return 5;
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

    private boolean giveCard() {
        Random random = new Random();
        int number = unUsedCards.size();
        String card = unUsedCards.get(random.nextInt(number));
        playerCards.add(0, card);
        first_card = 0;
        unUsedCards.remove(card);
        return true;
    }

    private void firstHand() {
        playerCards = new ArrayList<String>();
        int count = 0;
        while (count < FIRST_HAND) {
            if (giveCard()) {
                count++;
            }
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

    public static void main(String[] args) throws IOException {
        new GW();
    }
}
