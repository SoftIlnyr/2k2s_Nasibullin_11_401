package test;

import main.Plane;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by softi on 26.02.2016.
 */
public class PlaneTest {
    @Test
    public void firstParameterOfTheConstructorShouldBeName() {
        Plane plane = new Plane("F-35", 1000, 2000, 200);
        Assert.assertEquals("F-35", plane.getName());

    }

    @Test
    public void secondParameterOfTheConstructorShouldBeHp() {
        Plane plane = new Plane("F-35", 1000, 2000, 200);
        Assert.assertEquals(1000, plane.getHp());
    }

    @Test
    public void thirdParameterOfTheConstructorShouldBeViewDistance() {
        Plane plane = new Plane("F-35", 1000, 2000, 200);
        Assert.assertEquals(2000, plane.getViewDistance());
    }

    @Test
    public void fourthParameterOfTheConstructorShouldBeDamage() {
        Plane plane = new Plane("F-35", 1000, 2000, 200);
        Assert.assertEquals(200, plane.getDamage());
    }
}
