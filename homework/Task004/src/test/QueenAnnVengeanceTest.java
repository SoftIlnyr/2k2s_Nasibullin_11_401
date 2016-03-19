package test;

import main.BigGun;
import main.QueenAnnVengeance;
import main.Warship;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by softi on 26.02.2016.
 */
public class QueenAnnVengeanceTest {
    public static QueenAnnVengeance qav;
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
        qav = new QueenAnnVengeance("q1", 500, new ArrayList<>());
    }

    @Test
    public void firstParameterShouldBeName() {
        Assert.assertEquals("q1", qav.getName());
    }

    @Test
    public void secondParameterShouldBeHp() throws Exception {
        Assert.assertEquals(500, qav.getHp());
    }

    @Test
    public void testAddBigGunShouldWorkCorrect() throws Exception {
        BigGun bg = mock(BigGun.class);
        int x = qav.getBigGuns().size();
        qav.addBigGun(bg);
        int y = qav.getBigGuns().size();
        Assert.assertEquals(1, y - x);
        Assert.assertEquals("QAV adds a big gun!", outContent.toString());
    }

    @Test
    public void testShootBigTargetShouldWorkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        qav.shootBigTarget(warship);
        Assert.assertEquals("QAV shoots at warship with a big BOOM!", outContent.toString());
    }

    @Test
    public void testShootBigPointShouldWorkCorrect() throws Exception {
        qav.shootBigPoint(1, 5);
        Assert.assertEquals("QAV shoots to the point 1:5", outContent.toString());
    }

    @Test
    public void testMoveToShouldWorkCorrect() throws Exception {
        qav.moveTo(1, 5);
        Assert.assertEquals("QAV moves to the point 1:5", outContent.toString());
    }

    @Test
    public void testAttackShipShouldWorkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        qav.attackShip(warship);
        Assert.assertEquals("QAV shoots at warship with a big BOOM!", outContent.toString());
    }

    @Test
    public void testAttackPointShouldWorkCorrect() throws Exception {
        qav.attackPoint(1, 5);
        Assert.assertEquals("QAV shoots to the point 1:5", outContent.toString());
    }
}
