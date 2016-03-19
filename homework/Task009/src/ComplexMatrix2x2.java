/**
 * Created by softi on 24.02.2016.
 */
public class ComplexMatrix2x2 {
    private ComplexNumber[][] number = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        this(new ComplexNumber(), new ComplexNumber(), new ComplexNumber(), new ComplexNumber());
    }

    public ComplexMatrix2x2(ComplexNumber complexNumber) {
        this(complexNumber, complexNumber, complexNumber, complexNumber);
    }

    public ComplexMatrix2x2(ComplexNumber[][] number) {
        this.number = number;
    }

    public ComplexMatrix2x2(ComplexNumber number1, ComplexNumber number2, ComplexNumber number3, ComplexNumber number4) {
        number[0][0] = number1;
        number[0][1] = number2;
        number[1][0] = number3;
        number[1][1] = number4;
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 matrix2x2) {
        ComplexMatrix2x2 matrix = new ComplexMatrix2x2();
        for (int i = 0; i < matrix.number.length; i++) {
            for (int j = 0; j < matrix.number[0].length; j++) {
                matrix.number[i][j] = matrix.number[i][j].add(this.number[i][j]);
                matrix.number[i][j] = matrix.number[i][j].add(matrix2x2.number[i][j]);
            }
        }
        return matrix;
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 matrix2x2) {
        ComplexMatrix2x2 matrix = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix.number[i][j] = matrix.number[i][j].add(this.number[i][k].mult(matrix2x2.number[k][j]));
                }
            }
        }
        return matrix;
    }

    public ComplexNumber det(){
        return this.number[0][0].mult(this.number[1][1]).sub(this.number[0][1].mult(this.number[1][0]));
    }

    public String toString(){
        return (this.number[0][0] + "\t" + this.number[0][1] + "\n" + this.number[1][0] + "\t" + this.number[1][1]);
    }

    public ComplexNumber[][] getNumber() {
        return number;
    }
}
