import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.HashMap;

import static org.junit.Assert.fail;

/**
 * Created by softi on 26.02.2016.
 */
public class DeckTest {
    @Test
    public void getCardsShouldWorkCorrect() {
        String[] cards = Deck.getCards();
        Assert.assertTrue(cards[107].length() > 0);
    }

    @Test
    public void testGetCardIconsShouldWorkCorrect() throws Exception {
        try {
            HashMap<String, ImageIcon> map = Deck.getCardIcons();
        } catch (Exception e) {
            fail("There should not be any exception!");
        }
    }
}
