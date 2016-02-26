
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by softi on 26.02.2016.
 */
public class CardTest {
    @Test
    public void firstParameterShouldBePurpuse() {
        Card card = new Card("actual", "blue 0");
        Assert.assertEquals("actual", card.getPurpose());
    }

    @Test
    public void secondParameterShouldBeName() throws Exception {
        Card card = new Card("actual", "blue 0", 5);
        Assert.assertEquals("blue 0", card.getName());
    }

}
