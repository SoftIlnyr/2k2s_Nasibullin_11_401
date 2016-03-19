package test;

import main.Mine;
import main.Nautilus;
import main.Warship;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by softi on 26.02.2016.
 */
public class NautilusTest {
    public static Nautilus nautilus;

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
        nautilus = new Nautilus("Nemo", new ArrayList<>(), 1000, 100);
    }

    @Test
    public void firstParameterShouldBeName() {
        Assert.assertEquals("Nemo", nautilus.getName());
    }

    @Test
    public void thirdParameterShouldBeHp() throws Exception {
        Assert.assertEquals(1000, nautilus.getHp());


    }

    @Test
    public void fourthParameterShouldBeSpeed() throws Exception {
        Assert.assertEquals(100, nautilus.getSpeed());
    }

    @Test
    public void testAddMineSjouldWorkCorrect() throws Exception {
        Mine mine = mock(Mine.class);
        int x = nautilus.getMines().size();
        nautilus.addMine(mine);
        int y = nautilus.getMines().size();
        Assert.assertEquals(1, y - x);
    }

    @Test
    public void testDiveDepthShouldWorkCorrect() throws Exception {

        nautilus.diveDepth(72);
        Assert.assertEquals("main.Nautilus dives to 72", outContent.toString());

    }

    @Test
    public void testDropMineAndMoveTo() throws Exception {
        nautilus.dropMineAndMoveTo(1, 5);
        Assert.assertEquals("main.Nautilus drops a mine and goes to 1:5", outContent.toString());
    }

    @Test
    public void testMoveToShouldWorkCorrect() throws Exception {
        nautilus.moveTo(1, 5);
        Assert.assertEquals("main.Nautilus moves to 1:5", outContent.toString());
    }

    @Test
    public void testAttackShip() throws Exception {
        Warship warship = mock(Warship.class);
        nautilus.attackShip(warship);
        Assert.assertEquals("main.Nautilus can't attack a ship!", outContent.toString());
    }

    @Test
    public void testAttackPoint() throws Exception {
        nautilus.attackPoint(5, 7);
        Assert.assertEquals("main.Nautilus moves to 5:7\n" +
                "main.Nautilus drops a mine and goes to -5:-7", outContent.toString());

    }
}
