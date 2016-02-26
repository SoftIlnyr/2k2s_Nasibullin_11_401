/**
 * Created by Ilnyr on 17.02.2016.
 */
public class RationalFraction {
    private int num;
    private int den;

    public RationalFraction(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException();
        }
        this.num = x;
        this.den = y;
    }

    public RationalFraction() {
        this.num = 0;
        this.den = 1;
    }

    public int getDen() {
        return den;
    }

    public int getNum() {
        return num;
    }
}
