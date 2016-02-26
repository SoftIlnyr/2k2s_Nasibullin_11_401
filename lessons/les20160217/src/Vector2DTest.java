import org.junit.*;

/**
 * Created by Ilnyr on 17.02.2016.
 */
public class Vector2DTest {
    private static final double EPS = 1e-9;
    private static Vector2D simpleVector;
    private static Vector2D notSimpleVector;

    @Test
    public void defaultVectorShouldHaveZeroLength() {
        Assert.assertEquals(0, simpleVector.length(), EPS);
    }

    @Test
    public void lengthOfVectorShouldWorkCorrect() {
        Assert.assertEquals(Math.sqrt(notSimpleVector.getX() * notSimpleVector.getX() + notSimpleVector.getY() * notSimpleVector.getY()),
                notSimpleVector.length(), EPS);
    }

    @Test
    public void firstParamOfConstructorShouldBeSavedInX() {
        Vector2D v = new Vector2D(3, 4);
        Assert.assertEquals(3, v.getX(), EPS);
    }


    @Test
    public void secondParamOfConstructorShouldBeSavedInY() {
        Vector2D v = new Vector2D(3, 4);
        Assert.assertEquals(4, v.getY(), EPS);
    }

    @Ignore
    @Test(timeout = 100)
    public void checkTimeout() {
        while (true) ;
    }

    @Test
    public void checkIf5() {
        Vector2D v = new Vector2D();
        Assume.assumeTrue(v.getX() == 0);
    }

    @BeforeClass
    public static void beforeClass() {
        simpleVector = new Vector2D();
        notSimpleVector = new Vector2D(3, 4);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }
}
