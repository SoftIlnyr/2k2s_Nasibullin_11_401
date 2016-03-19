import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by softi on 24.02.2016.
 */
public class ComplexMatrix2x2Test {
    public static ComplexNumber zcn, cn1, cn2, cn3, cn4;
    public static ComplexMatrix2x2 cm;

    @BeforeClass
    public static void BeforeClass() {
        zcn = new ComplexNumber();
        cn1 = new ComplexNumber(1, 2);
        cn2 = new ComplexNumber(3, -4);
        cn3 = new ComplexNumber(-5, 6);
        cn4 = new ComplexNumber(-7, -8);
        cm = new ComplexMatrix2x2(cn1, cn2, cn3, cn4);
    }

    @Test
    public void DefaultCMShouldHaveZeroValues() {
        ComplexMatrix2x2 cm = new ComplexMatrix2x2();
        ComplexNumber cn = new ComplexNumber();
        ComplexMatrix2x2 inspect = new ComplexMatrix2x2(cn);
        Assert.assertEquals(inspect.getNumber(), cm.getNumber());
    }

    @Test
    public void methodAddShouldWorkCorrect() {
        ComplexNumber n0 = new ComplexNumber(-5, 1);
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2(n0);
        ComplexMatrix2x2 cm3 = cm.add(cm2);
        ComplexNumber n1 = cm.getNumber()[0][0].add(n0);
        ComplexNumber n2 = cm.getNumber()[0][1].add(n0);
        ComplexNumber n3 = cm.getNumber()[1][0].add(n0);
        ComplexNumber n4 = cm.getNumber()[1][1].add(n0);
        ComplexMatrix2x2 inspect = new ComplexMatrix2x2(n1, n2, n3, n4);
        Assert.assertArrayEquals(inspect.getNumber(), cm3.getNumber());
        /*ComplexNumber cn1 = mock(ComplexNumber.class);
        ComplexNumber cn2 = mock(ComplexNumber.class);
        when(cn1.setRealPart(anyDouble())).thenCallRealMethod();
        when(cn1.add(any(ComplexNumber.class))).thenReturn(new ComplexNumber(1, 3));
        when(cn2.add(any(ComplexNumber.class))).thenReturn(new ComplexNumber(2, 4));
        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2(cn1);
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2(cn2);
        ComplexMatrix2x2 cm3 = cm1.add(cm2);
        ComplexMatrix2x2 inspect = new ComplexMatrix2x2();
        Assert.assertArrayEquals(inspect.getNumber(), cm3.getNumber());*/
    }

    @Ignore
    @Test
    public void methodMultShouldWorkCorrect() {
        ComplexNumber n0 = new ComplexNumber(-5, 1);
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2(n0);
        ComplexMatrix2x2 cm3 = cm.mult(cm2);
        ComplexNumber n1 = cm.getNumber()[0][0].mult(n0).add(cm.getNumber()[0][1].mult(n0));
        ComplexNumber n2 = cm.getNumber()[0][0].mult(n0).add(cm.getNumber()[0][1].mult(n0));
        ComplexNumber n3 = cm.getNumber()[1][0].mult(n0).add(cm.getNumber()[1][1].mult(n0));
        ComplexNumber n4 = cm.getNumber()[1][1].mult(n0).add(cm.getNumber()[1][1].mult(n0));
        ComplexMatrix2x2 inspect = new ComplexMatrix2x2(n1, n2, n3, n4);
        Assert.assertArrayEquals(inspect.getNumber(), cm3.getNumber());
    }

    @Test
    public void methodDetShouldWorkCorrect() {
        ComplexNumber cn = cm.det();
        ComplexNumber inspect = cn1.mult(cn4).sub(cn2.mult(cn3));
        Assert.assertEquals(inspect, cn);
    }
}
