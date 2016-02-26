import org.junit.Assert;
import org.junit.Test;

/**
 * Created by softi on 26.02.2016.
 */
public class MidGunTest {
    @Test
    public void firstParametsShouldBeCaliber() {
        MidGun midGun = new MidGun(155, 500, 10);
        Assert.assertEquals(155, midGun.getCaliber());
    }

    @Test
    public void secondParameterShouldBeDamage() throws Exception {
        MidGun midGun = new MidGun(155, 500, 10);
        Assert.assertEquals(500, midGun.getDamage());
    }

    @Test
    public void thirdParameterShouldBeRange() {
        MidGun midGun = new MidGun(155, 500, 10);
        Assert.assertEquals(10, midGun.getRange());
    }
}
