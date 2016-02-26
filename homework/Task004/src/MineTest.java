import org.junit.Assert;
import org.junit.Test;

/**
 * Created by softi on 26.02.2016.
 */
public class MineTest {
    @Test
    public void firstParameterOfTheConstructorShouldBeDamage() {
        Mine mine = new Mine(500, 60, 2);
        Assert.assertEquals(500, mine.damage);
    }

    @Test
    public void secondParameterOfTheConstructorShouldBeTimer() {
        Mine mine = new Mine(500, 60, 2);
        Assert.assertEquals(60, mine.timer);
    }

    @Test
    public void thirdParameterOfTheConstructorShouldBeDiameter() {
        Mine mine = new Mine(500, 60, 2);
        Assert.assertEquals(2, mine.diameter);
    }
}
