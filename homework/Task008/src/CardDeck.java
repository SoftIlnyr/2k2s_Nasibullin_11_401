import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Ilnyr on 22.11.2015.
 */
public class CardDeck {
    private static String[] cardNames;
    private static HashMap<String, ImageIcon> cardIcons;

    public static String[] getCards() {
        if (cardNames == null) {
            String[] colors = {"blue", "green", "red", "yellow"};
            int count = 0;
            cardNames = new String[108];
            for (String color : colors) {
                cardNames[count] = color + " " + 0;
                count++;
                for (int i = 1; i < 10; i++) {
                    for (int k = 0; k < 2; k++) {
                        cardNames[count] = color + " " + i;
                        count++;
                    }
                }
                for (int k = 0; k < 2; k++) {
                    cardNames[count] = color + " reverse";
                    count++;
                }
                for (int k = 0; k < 2; k++) {
                    cardNames[count] = color + " skip";
                    count++;
                }
                for (int k = 0; k < 2; k++) {
                    cardNames[count] = color + " taketwo";
                    count++;
                }
            }
            for (int k = 0; k < 4; k++) {
                cardNames[count] = "zorder";
                count++;
            }
            for (int k = 0; k < 4; k++) {
                cardNames[count] = "zorder take 4";
                count++;
            }
        }
        return cardNames;
    }

    public static HashMap<String, ImageIcon> getCardIcons() throws IOException {
        if (cardIcons == null) {
            cardIcons = new HashMap<String, ImageIcon>();
            for (String card : getCards()) {
                ImageIcon icon = getIcon(card);
                cardIcons.put(card, icon);
            }
            for (String color : new String[]{"blue", "green", "yellow", "red"}) {
                String card = "zorder " + color;
                ImageIcon icon = getIcon(card);
                cardIcons.put(card, icon);
            }
            for (String color : new String[]{"blue", "green", "yellow", "red"}) {
                String card = "zorder take 4 " + color;
                ImageIcon icon = getIcon(card);
                cardIcons.put(card, icon);
            }
            ImageIcon back = getIcon("back");
            cardIcons.put("back", back);
        }
        return cardIcons;
    }

    private static ImageIcon getIcon(String card) {
        String path = "cards/" + card + ".png";
        ImageIcon icon = new ImageIcon(path);
        return icon;
    }
}
