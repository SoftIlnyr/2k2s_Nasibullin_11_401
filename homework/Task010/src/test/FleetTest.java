package test;

import main.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by softi on 26.02.2016.
 */
public class FleetTest {
    public static Fleet fleet;
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
        fleet = new Fleet("Russia", new ArrayList<>());
        Warship sh1 = mock(Jackdaw.class);
        Warship sh2 = mock(Aircraft.class);
        Warship sh3 = mock(Nautilus.class);
        fleet.addWarship(sh1);
        fleet.addWarship(sh2);
        fleet.addWarship(sh3);

    }

    @Test
    public void firstParameterShouldBeName() {
        Fleet f1 = new Fleet("Russia", new ArrayList<>());
        Assert.assertEquals("Russia", f1.getName());
    }

    @Test
    public void testAddWarshipShouldWorkCorrect() throws Exception {
        Fleet f1 = new Fleet("Russia", new ArrayList<>());
        Warship warship = mock(Warship.class);
        int x = f1.getWarships().size();
        f1.addWarship(warship);
        int y = f1.getWarships().size();
        Assert.assertEquals(1, y - x);

    }

    @Test
    public void testFullAttackTargetShouldWorkCorrect() throws Exception {
        Warship target = mock(Warship.class);
        fleet.fullAttackTarget(target);
        Assert.assertEquals("", outContent.toString());
    }

    @Test
    public void testFullMoveToPointShouldWorkCorrect() throws Exception {
        fleet.fullMoveToPoint(1, 5);
        Assert.assertEquals("", outContent.toString());

    }
}
