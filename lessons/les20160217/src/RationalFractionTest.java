import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ilnyr on 17.02.2016.
 */
public class RationalFractionTest {

    @Test
    public void firstParamOfConstructorShouldBeSavedInNum() {
        RationalFraction r = new RationalFraction(1, 2);
        Assert.assertEquals(1, r.getNum());
    }

    @Test
    public void secondParamOfConstructorShouldBeSavedInDen() {
        RationalFraction r = new RationalFraction(1, 2);
        Assert.assertEquals(2, r.getDen());
    }

    @Test(expected = ArithmeticException.class)
    public void RFDenominatorShouldNotBeZero() {
        RationalFraction r = new RationalFraction(1, 0);
    }
}
