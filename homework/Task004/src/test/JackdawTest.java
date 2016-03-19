package test;

import main.Jackdaw;
import main.MidGun;
import main.Warship;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by softi on 26.02.2016.
 */
public class JackdawTest {
    public static Jackdaw jackdaw;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @BeforeClass
    public static void BeforeClass() {
        jackdaw = new Jackdaw("Assassin", 100, new ArrayList<>());
    }

    @Test
    public void firstParameterShouldBeName() {
        Assert.assertEquals("Assassin", jackdaw.getName());
    }

    @Test
    public void secondParameterShouldBeHp() throws Exception {
        Assert.assertEquals(100, jackdaw.getHp());
    }

    @Test
    public void testAddMidGunSHuldWorkCorrect() throws Exception {
        MidGun midGun = mock(MidGun.class);
        int x = jackdaw.getMidGuns().size();
        jackdaw.addMidGun(midGun);
        int y = jackdaw.getMidGuns().size();
        Assert.assertEquals(1, y - x);
    }

    @Test
    public void testShootMidTargetShouldWorkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        jackdaw.shootMidTarget(warship);
        Assert.assertEquals("Assassin shoots to the warship!", outContent.toString());
    }

    @Test
    public void testShootMidPointShouldWorkCorrect() throws Exception {

        jackdaw.shootMidPoint(1, 5);
        Assert.assertEquals("Assassin shoot to the point 1:5 with midguns", outContent.toString());

    }

    @Test
    public void testScoutPointShouldWorkCorrect() throws Exception {

        jackdaw.scoutPoint(1, 8);
        Assert.assertEquals("Assassin scouts point 1:8", outContent.toString());

    }

    @Test
    public void testBoardingShouldWorkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        jackdaw.boarding(warship);
        Assert.assertEquals("Assassin is taking an enemy ship!", outContent.toString());
    }

    @Test
    public void testSmokeShouldWorkCorrect() throws Exception {

        jackdaw.smoke();
        Assert.assertEquals("Assassin has not a smoke!", outContent.toString());

    }

    @Test
    public void testMoveToShouldWorkCorrect() throws Exception {
        jackdaw.moveTo(1, 5);
        Assert.assertEquals("Assassin flies to the point", outContent.toString());
    }

    @Test
    public void testAttackShipShouldWOrkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        jackdaw.attackShip(warship);
        Assert.assertEquals("Assassin shoots to the warship!", outContent.toString());


    }

    @Test
    public void testAttackPointShouldWorkCorrect() throws Exception {
        jackdaw.scoutPoint(1, 8);
        Assert.assertEquals("Assassin scouts point 1:8", outContent.toString());

    }
}
