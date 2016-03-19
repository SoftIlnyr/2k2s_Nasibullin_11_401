package test;

import main.BigGun;
import main.EpicMachine;
import main.Warship;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by softi on 26.02.2016.
 */
public class EpicMachineTest {
    public static EpicMachine epicMachine;
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
        epicMachine = new EpicMachine("Terminator", 10000, new ArrayList<BigGun>());
    }

    @Test
    public void firstParameterShouldBeName() {
        Assert.assertEquals("Terminator", epicMachine.getName());
    }

    @Test
    public void secondParameterShouldBeHp() throws Exception {
        Assert.assertEquals(10000, epicMachine.getHp());
    }

    @Test
    public void testAddBigGunSHouldWorkCorrect() throws Exception {
        BigGun bg = mock(BigGun.class);
        int x = epicMachine.getBigGuns().size();
        epicMachine.addBigGun(bg);
        int y = epicMachine.getBigGuns().size();
        Assert.assertEquals(1, y - x);
    }

    @Test
    public void testShootBigTargetShouldWorkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        epicMachine.shootBigTarget(warship);
        Assert.assertEquals("Terminator shoots a warship with a VERY BIG GUN!", outContent.toString());
    }

    @Test
    public void testShootBigPointShouldWorkCorrect() throws Exception {
        epicMachine.shootBigPoint(1, 5);
        Assert.assertEquals("Terminator shoots to the point with a VERY BIG GUN!", outContent.toString());
    }

    @Test
    public void testScoutShouldWorkCorrect() throws Exception {
        epicMachine.scoutPoint(1, 5);
        Assert.assertEquals("Terminator is to gorgeous to scout!", outContent.toString());
    }

    @Test
    public void testBoardingShouldWorkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        epicMachine.boarding(warship);
        Assert.assertEquals("Terminator rams an enemy warship!", outContent.toString());
    }

    @Test
    public void testSmokeShouldWorkCorrect() throws Exception {

        epicMachine.smoke();
        Assert.assertEquals("Terminator produces smoke! Nobody can see!", outContent.toString());

    }

    @Test
    public void testMoveToShouldWorkCorrect() throws Exception {

        epicMachine.moveTo(1, 5);
        Assert.assertEquals("Terminator moves to point 1:5", outContent.toString());

    }

    @Test
    public void testAttackWarship() throws Exception {
        Warship warship = mock(Warship.class);
        epicMachine.attackShip(warship);
        Assert.assertEquals("Terminator shoots a warship with a VERY BIG GUN!", outContent.toString());
    }

    @Test
    public void testAttackPoint() throws Exception {
        epicMachine.attackPoint(1, 5);
        Assert.assertEquals("Terminator shoots to the point with a VERY BIG GUN!", outContent.toString());

    }
}
