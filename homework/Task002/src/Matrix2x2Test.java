import org.junit.Assert;
import org.junit.Test;

/**
 * Created by softi on 23.02.2016.
 */
public class Matrix2x2Test {
    final double EPS = 1e-9;

    @Test
    public void defaultMatrixShouldBeZero() {
        Matrix2x2 m = new Matrix2x2();
        double[][] zerom = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                zerom[i][j] = 0.0;
            }
        }
        Assert.assertArrayEquals(zerom, m.getElement());
    }

    @Test
    public void constructedByDoubleMatrixShouldBeEqualThatDouble() {
        Matrix2x2 m = new Matrix2x2(5.1);
        double[][] inspect = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                inspect[i][j] = 5.1;
            }
        }
        Assert.assertArrayEquals(inspect, m.getElement());
    }

    @Test
    public void constructedByArrayMatrixShouldBeEqualThatArray() {
        double[][] inspect = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                inspect[i][j] = i + j;
            }
        }
        Matrix2x2 m = new Matrix2x2(inspect);
        Assert.assertArrayEquals(inspect, m.getElement());
    }

    @Test
    public void constructedByFourDoubleMatrixShouldContainThisDoubleInRightPlaces() {
        Matrix2x2 m = new Matrix2x2(1, 2, 3, 4);
        double[][] inspect = new double[2][2];
        inspect[0][0] = 1;
        inspect[0][1] = 2;
        inspect[1][0] = 3;
        inspect[1][1] = 4;
        Assert.assertArrayEquals(inspect, m.getElement());
    }

    @Test
    public void methodAddShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(3, 3, 3, 3);
        Matrix2x2 m3 = m1.add(m2);
        double[][] inspect = new double[2][2];
        inspect[0][0] = 4;
        inspect[0][1] = 5;
        inspect[1][0] = 6;
        inspect[1][1] = 7;
        Assert.assertArrayEquals(inspect, m3.getElement());
    }

    @Test
    public void methodAdd2ShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(3, 3, 3, 3);
        m1.add2(m2);
        double[][] inspect = new double[2][2];
        inspect[0][0] = 4;
        inspect[0][1] = 5;
        inspect[1][0] = 6;
        inspect[1][1] = 7;
        Assert.assertArrayEquals(inspect, m1.getElement());
    }

    @Test
    public void methodSubShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(3, 3, 3, 3);
        Matrix2x2 m3 = m1.sub(m2);
        double[][] inspect = new double[2][2];
        inspect[0][0] = -2;
        inspect[0][1] = -1;
        inspect[1][0] = 0;
        inspect[1][1] = 1;
        Assert.assertArrayEquals(inspect, m3.getElement());
    }

    @Test
    public void methodSub2ShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(3, 3, 3, 3);
        m1.sub2(m2);
        double[][] inspect = new double[2][2];
        inspect[0][0] = -2;
        inspect[0][1] = -1;
        inspect[1][0] = 0;
        inspect[1][1] = 1;
        Assert.assertArrayEquals(inspect, m1.getElement());

    }

    @Test
    public void methodMultNumberShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        double d = 2;
        Matrix2x2 m2 = m1.multNumber(d);
        double[][] inspect = new double[2][2];
        inspect[0][0] = 2;
        inspect[0][1] = 4;
        inspect[1][0] = 6;
        inspect[1][1] = 8;
        Assert.assertArrayEquals(inspect, m2.getElement());
    }

    @Test
    public void MethodMultNumber2ShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        double d = 2;
        m1.multNumber2(d);
        double[][] inspect = new double[2][2];
        inspect[0][0] = 2;
        inspect[0][1] = 4;
        inspect[1][0] = 6;
        inspect[1][1] = 8;
        Assert.assertArrayEquals(inspect, m1.getElement());
    }

    @Test
    public void MethodMultShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(4, 3, 2, 1);
        Matrix2x2 m3 = m1.mult(m2);
        double[][] inspect = new double[2][2];
        inspect[0][0] = 8;
        inspect[0][1] = 5;
        inspect[1][0] = 20;
        inspect[1][1] = 13;
        Assert.assertArrayEquals(inspect, m3.getElement());
    }

    @Test
    public void MethodMult2ShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(4, 3, 2, 1);
        m1.mult2(m2);
        double[][] inspect = new double[2][2];
        inspect[0][0] = 8;
        inspect[0][1] = 5;
        inspect[1][0] = 20;
        inspect[1][1] = 13;
        Assert.assertArrayEquals(inspect, m1.getElement());
    }

    @Test
    public void matrixDetShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        double det = m1.det();
        Assert.assertEquals(-2, det, EPS);
    }

    @Test
    public void methodTransponShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        m1.transpon();
        double[][] inspect = new double[2][2];
        inspect[0][0] = 1;
        inspect[0][1] = 3;
        inspect[1][0] = 2;
        inspect[1][1] = 4;
        Assert.assertArrayEquals(inspect, m1.getElement());
    }

    @Test
    public void methodInverseMatrixShouldBeCorrect() throws CloneNotSupportedException {
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = m1.inverseMatrix();
        Matrix2x2 m3 = m1.mult(m2);
        double[][] inspect = new double[2][2];
        inspect[0][0] = 1;
        inspect[0][1] = 0;
        inspect[1][0] = 0;
        inspect[1][1] = 1;
        Assert.assertArrayEquals(inspect, m3.getElement());
    }

    @Test
    public void methodEqDiaonalShouldBeCorrect() {
        Matrix2x2 m1 = new Matrix2x2(3, 4, 1, 2);
        Matrix2x2 m2 = m1.equivalentDiagonal();
        double[][] inspect = new double[2][2];
        inspect[0][0] = 1;
        inspect[0][1] = 0;
        inspect[1][0] = 0;
        inspect[1][1] = -2;
        Assert.assertArrayEquals(inspect, m2.getElement());
    }
}