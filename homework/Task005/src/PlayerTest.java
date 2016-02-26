import org.junit.Assert;
import org.junit.Test;

/**
 * Created by softi on 26.02.2016.
 */
public class PlayerTest {
    @Test
    public void firstParameterShouldBeName() {
        Player player = new Player("Ilnyr", 1);
        Assert.assertEquals("Ilnyr", player.name);
    }

    @Test
    public void secondParameterShouldBeId() throws Exception {
        Player player = new Player("Ilnyr", 2);
        Assert.assertEquals(2, player.id);
    }

    @Test
    public void testSetStatusShouldWorkCorrect() throws Exception {
        Player player = new Player("Ilnyr", 1);
        player.setStatus("Blya");
        Assert.assertEquals("Blya", player.getStatus());
    }
}
