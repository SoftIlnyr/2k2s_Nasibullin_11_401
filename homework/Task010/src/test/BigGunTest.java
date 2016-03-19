package test;

import main.BigGun;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by softi on 25.02.2016.
 */
public class BigGunTest {
    @Test
    public void firstParameterOfTheConstructorShouldBeCaliber() {
        BigGun bg = new BigGun(12, 100, 1000);
        Assert.assertEquals(12, bg.getCaliber());
    }

    @Test
    public void secondParameterOfTheConstructorShouldBeDamage() {
        BigGun bg = new BigGun(12, 100, 1000);
        Assert.assertEquals(100, bg.getDamage());
    }

    @Test
    public void thirdParameterOfTheConstructorShouldBeWeight() {
        BigGun bg = new BigGun(12, 100, 1000);
        Assert.assertEquals(1000, bg.getWeight());
    }



}
