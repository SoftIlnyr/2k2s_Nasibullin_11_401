import org.junit.Assert;
import org.junit.Test;

/**
 * Created by softi on 26.02.2016.
 */
public class TorpedoTest {
    @Test
    public void firstParameterOfTheConstructorShouldBeType() {
        Torpedo torpedo = new Torpedo("nucklear", 10000, 1500);
        Assert.assertEquals("nucklear", torpedo.getType());
    }

    @Test
    public void secondParameterOfTheConstructorShouldBeDamage() {
        Torpedo torpedo = new Torpedo("nucklear", 10000, 1500);
        Assert.assertEquals(10000, torpedo.getDamage());
    }

    @Test
    public void thirdParameterOfTheConstructorShouldBeRange() {
        Torpedo torpedo = new Torpedo("nucklear", 10000, 1500);
        Assert.assertEquals(1500, torpedo.getRange());
    }

}
