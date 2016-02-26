/**
 * Created by softi on 23.02.2016.
 */
public class Matrix2x2 {
    private double[][] element = new double[2][2];

    public Matrix2x2() {
        element[0][0] = 0.0;
        element[0][1] = 0.0;
        element[1][0] = 0.0;
        element[1][1] = 0.0;
    }

    public Matrix2x2(double v) {
        element[0][0] = v;
        element[0][1] = v;
        element[1][0] = v;
        element[1][1] = v;
    }

    public Matrix2x2(double[][] array) {
        element[0][0] = array[0][0];
        element[0][1] = array[0][1];
        element[1][0] = array[1][0];
        element[1][1] = array[1][1];
    }

    public Matrix2x2(double e1, double e2, double e3, double e4) {
        element[0][0] = e1;
        element[0][1] = e2;
        element[1][0] = e3;
        element[1][1] = e4;
    }

    public double[][] getElement() {
        return element;
    }

    public void setElement(double[][] element) {
        this.element = element;
    }

    public Matrix2x2 add(Matrix2x2 m2) {
        Matrix2x2 m1 = new Matrix2x2(this.getElement());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m1.element[i][j] += m2.element[i][j];
            }
        }
        return m1;
    }

    public void add2(Matrix2x2 m2) {
        this.element = this.add(m2).element;
    }

    public Matrix2x2 sub(Matrix2x2 m2) {
        Matrix2x2 m1 = new Matrix2x2(this.getElement());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m1.element[i][j] -= m2.element[i][j];
            }
        }
        return m1;
    }

    public void sub2(Matrix2x2 m2) {
        this.element = this.sub(m2).element;
    }

    public Matrix2x2 multNumber(double d) {
        Matrix2x2 matrix = this;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix.element[i][j] *= d;
            }
        }
        return matrix;
    }

    public void multNumber2(double d) {
        this.element = this.multNumber(d).element;

    }

    public Matrix2x2 mult(Matrix2x2 m2) {
        Matrix2x2 matrix = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix.element[i][j] += this.element[i][k] * m2.element[k][j];
                }
            }
        }
        return matrix;
    }

    public void mult2(Matrix2x2 m2) {
        this.element = this.mult(m2).element;
    }

    public double det() {
        return this.element[0][0] * this.element[1][1] - this.element[0][1] * this.element[1][0];
    }

    public void transpon() {
        double x = element[0][1];
        element[0][1] = element[1][0];
        element[1][0] = x;
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 temp = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                temp.element[i][j] = this.element[i][j];
            }
        }
        double x = temp.element[0][0];
        temp.element[0][0] = temp.element[1][1];
        temp.element[1][1] = x;
        x = temp.element[0][1];
        temp.element[0][1] = temp.element[1][0];
        temp.element[1][0] = x;
        temp.element[0][1] *= -1;
        temp.element[1][0] *= -1;
        temp.transpon();
        temp.multNumber(1 / temp.det());
        return temp;
    }

    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 temp = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                temp.element[i][j] = this.element[i][j];
            }
        }
        if (temp.element[1][0] < temp.element[0][0]) {
            double[] x = temp.element[0];
            temp.element[0] = temp.element[1];
            temp.element[1] = x;
        }
        double r = temp.element[1][0] / temp.element[0][0];
        for (int i = 0; i < 2; i++) {
            temp.element[1][i] -= temp.element[0][i] * r;
        }
        r = temp.element[0][1] / temp.element[1][1];
        for (int i = 0; i < 2; i++) {
            temp.element[0][i] -= temp.element[1][i] * r;
        }
        return temp;
    }
}
