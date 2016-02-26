/**
 * Created by softi on 24.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ComplexNumber n1 = new ComplexNumber();
        ComplexNumber n2 = new ComplexNumber(0, 1);
        System.out.println(n1.equals(n2));

        ComplexNumber n0 = new ComplexNumber(-5, 1);
        ComplexNumber cn1 = new ComplexNumber(1, 2);
        ComplexNumber cn2 = new ComplexNumber(3, -4);
        ComplexNumber cn3 = new ComplexNumber(-5, 6);
        ComplexNumber cn4 = new ComplexNumber(-7, -8);

        ComplexMatrix2x2 cm1 = new ComplexMatrix2x2(n0);
        ComplexMatrix2x2 cm2 = new ComplexMatrix2x2(cn1, cn2, cn3, cn4);
        ComplexMatrix2x2 cm3 = cm1.mult(cm2);
        System.out.println(cm3);
    }
}
