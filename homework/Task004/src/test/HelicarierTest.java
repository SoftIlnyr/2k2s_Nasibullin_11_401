package test;

import main.Helicarier;
import main.Plane;
import main.Warship;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by softi on 26.02.2016.
 */
public class HelicarierTest {
    public static Helicarier helicarier;

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
        helicarier = new Helicarier("Shield", 1000, new ArrayList<>());
    }

    @Test
    public void firstParameterShouldBeName() {
        Assert.assertEquals("Shield", helicarier.getName());
    }

    @Test
    public void secondParameterShouldBeHp() throws Exception {
        Assert.assertEquals(1000, helicarier.getHp());
    }

    @Test
    public void testAddPlaneShouldWorkCorrect() throws Exception {
        Plane plane = mock(Plane.class);
        int x = helicarier.getPlanes().size();
        helicarier.addPlane(plane);
        int y = helicarier.getPlanes().size();
        Assert.assertEquals(1, y - x);
    }

    @Test
    public void testPlaneToVentureShouldWorkCorrect() throws Exception {
        helicarier.planeToVenture(1, 5);
        Assert.assertEquals("main.Helicarier sends a plane to the point 1:5", outContent.toString());
    }

    @Test
    public void testPlaneToAttackShouldWorkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        helicarier.planeAttackTarget(warship);
        Assert.assertEquals("main.Helicarier sends all planes to attack warship", outContent.toString());
    }

    @Test
    public void testMoveToShouldWorkCorrect() throws Exception {
        helicarier.moveTo(4, 2);
        Assert.assertEquals("main.Helicarier moves to point 4:2", outContent.toString());
    }

    @Test
    public void testAttackShipShouldWorkCorrect() throws Exception {
        Warship warship = mock(Warship.class);
        helicarier.attackShip(warship);
        Assert.assertEquals("main.Helicarier sends all planes to attack warship", outContent.toString());

    }

    @Test
    public void testAttackPointShouldWorkCorrect() throws Exception {
        helicarier.attackPoint(1, 5);
        Assert.assertEquals("main.Helicarier sends a plane to the point 1:5", outContent.toString());
    }
}
