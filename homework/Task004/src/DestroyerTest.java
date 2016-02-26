import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by softi on 26.02.2016.
 */
public class DestroyerTest {
    public static Destroyer destroyer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeClass
    public static void BeforeClass() {
        destroyer = new Destroyer("Number 1", 1000, 60);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void firstParameterOfTheConstructorShouldBeName() {
        Assert.assertEquals("Number 1", destroyer.getName());
    }

    @Test
    public void secondParameterOfTheConstructorShouldBeHp() {
        Assert.assertEquals(1000, destroyer.getHp());
    }

    @Test
    public void thirdParameterOfTheConstructorShouldBeSpeed() {
        Assert.assertEquals(60, destroyer.getSpeed());
    }

    @Test
    public void testAddTorpedoMethodShoildWorkCorrect() throws Exception {
        Destroyer d1 = new Destroyer("A", 5, 5);
        int x = d1.getTorpedos().size();
        Torpedo torpedo = mock(Torpedo.class);
        d1.addTorpedo(torpedo);
        int y = d1.getTorpedos().size();
        Assert.assertEquals(1, y - x);
    }

    @Test
    public void testScoutPointShouldWorkCorrect() throws Exception {
        destroyer.scoutPoint(5, 6);
        Assert.assertEquals("Destroyer moves to the point 5:6", outContent.toString());
    }

    @Test
    public void testBoardingShouldWorkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        destroyer.boarding(warship);
        Assert.assertEquals("Destroyer attacks tagged ship", outContent.toString());
    }

    @Test
    public void testSmokeShouldWorkCorrect() throws Exception {
        destroyer.smoke();
        Assert.assertEquals("Destroyer makes a big smoke veil. No Warship can see at the 5 km distance!", outContent.toString());

    }

    @Test
    public void testLaunchTorpedoAngleShouldWorkCorrect() throws Exception {
        Destroyer d1 = new Destroyer("a", 5, 5);
        Torpedo torpedo = mock(Torpedo.class);
        when(torpedo.getRange()).thenReturn(5);
        d1.addTorpedo(torpedo);
        destroyer.launchTorpedoAngle(5);
        Assert.assertEquals("Destoyer picked a torpedo\n" +
                "Destroyer launched all torpedoes to the angle 5\n" +
                "...they fly max to the 5 kilometers", outContent.toString());

    }

    @Test
    public void testLaunchTorpedoTargetShouldWorkCorrect() throws Exception {
        Destroyer d1 = new Destroyer("a", 5, 5);
        Torpedo torpedo = mock(Torpedo.class);
        when(torpedo.getDamage()).thenReturn(5);
        d1.addTorpedo(torpedo);
        Warship warship = mock(Warship.class);
        destroyer.launchTorpedoTarget(warship);
        Assert.assertEquals("Destoyer picked a torpedo\n" +
                "Destroyer launched all torpedoes to the target \n" +
                "...and damages 5 hp", outContent.toString());
    }

    @Test
    public void testMoveTo() throws Exception {
        destroyer.moveTo(1, 8);
        Assert.assertEquals("Destroyer moves to the 1:8", outContent.toString());
    }

    @Test
    public void testAttackShipShouldWorkCorrect() throws Exception {
        Destroyer d1 = new Destroyer("a", 5, 5);
        Torpedo torpedo = mock(Torpedo.class);
        when(torpedo.getDamage()).thenReturn(5);
        d1.addTorpedo(torpedo);
        Warship warship = mock(Warship.class);
        destroyer.attackShip(warship);
        Assert.assertEquals("Destoyer picked a torpedo\n" +
                "Destroyer launched all torpedoes to the target \n" +
                "...and damages 5 hp", outContent.toString());
    }

    @Test
    public void testAttackPointShouldWorkCorrect() throws Exception {
        Destroyer d1 = new Destroyer("a", 5, 5);
        Torpedo torpedo = mock(Torpedo.class);
        when(torpedo.getRange()).thenReturn(5);
        d1.addTorpedo(torpedo);
        destroyer.attackPoint(5, 1);
        Assert.assertEquals("Destoyer picked a torpedo\n" +
                "Destroyer launched all torpedoes to the angle 5\n" +
                "...they fly max to the 5 kilometers", outContent.toString());

    }
}

