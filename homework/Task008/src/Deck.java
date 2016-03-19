/**
 * Created by Ilnyr on 22.11.2015.
 */
public class Deck {
    private static String[] cardNames;

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
}
