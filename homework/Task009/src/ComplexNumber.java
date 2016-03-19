public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public String toString() {
        if (this.realPart != 0) {
            if (this.imaginaryPart > 0) {
                return this.realPart + " + " + this.imaginaryPart + " * i";
            } else if (this.imaginaryPart == 0) {
                return this.realPart + "";
            } else {
                return this.realPart + " - " + this.imaginaryPart * (-1) + " * i";
            }
        } else {
            if (this.imaginaryPart != 0) {
                return this.imaginaryPart + " * i";
            } else if (this.imaginaryPart == 0) {
                return "0";
            }
        }
        return null;
    }

    public ComplexNumber add(ComplexNumber complexNumber) {
        ComplexNumber complexNumber1 = new ComplexNumber(this.realPart, this.imaginaryPart);
        complexNumber1.realPart += complexNumber.realPart;
        complexNumber1.imaginaryPart += complexNumber.getImaginaryPart();
        return complexNumber1;
    }

    public void add2(ComplexNumber complexNumber) {
        ComplexNumber number = new ComplexNumber(this.realPart, this.imaginaryPart);
        this.realPart = number.add(complexNumber).realPart;
        this.imaginaryPart = number.add(complexNumber).imaginaryPart;
    }

    public ComplexNumber sub(ComplexNumber complexNumber) {
        ComplexNumber complexNumber1 = new ComplexNumber(this.realPart, this.imaginaryPart);
        complexNumber1.realPart -= complexNumber.realPart;
        complexNumber1.imaginaryPart -= complexNumber.getImaginaryPart();
        return complexNumber1;
    }

    public void sub2(ComplexNumber complexNumber) {
        ComplexNumber number = new ComplexNumber(this.realPart, this.imaginaryPart);
        this.realPart = number.sub(complexNumber).realPart;
        this.imaginaryPart = number.sub(complexNumber).imaginaryPart;
    }

    public ComplexNumber mult(ComplexNumber complexNumber) {
        ComplexNumber number = new ComplexNumber(this.realPart, this.imaginaryPart);
        number.realPart = this.realPart * complexNumber.realPart - this.imaginaryPart * complexNumber.imaginaryPart;
        number.imaginaryPart = this.realPart * complexNumber.imaginaryPart + this.imaginaryPart * complexNumber.realPart;
        return number;
    }

    public void mult2(ComplexNumber complexNumber) {
        ComplexNumber number = new ComplexNumber(this.realPart, this.imaginaryPart);
        this.realPart = number.mult(complexNumber).realPart;
        this.imaginaryPart = number.mult(complexNumber).imaginaryPart;
    }

    public ComplexNumber div(ComplexNumber complexNumber) {
        ComplexNumber number = new ComplexNumber(this.realPart, this.imaginaryPart);
        number.realPart = (this.realPart * complexNumber.realPart + this.imaginaryPart * complexNumber.imaginaryPart);
        number.realPart = number.realPart / (complexNumber.realPart * complexNumber.realPart + complexNumber.imaginaryPart * complexNumber.imaginaryPart);
        number.imaginaryPart = (complexNumber.realPart * this.imaginaryPart - complexNumber.imaginaryPart * this.realPart);
        number.imaginaryPart = number.imaginaryPart / (complexNumber.realPart * complexNumber.realPart + complexNumber.imaginaryPart * complexNumber.imaginaryPart);
        return number;
    }

    public void div2(ComplexNumber complexNumber) {
        ComplexNumber number = new ComplexNumber(this.realPart, this.imaginaryPart);
        this.realPart = number.div(complexNumber).realPart;
        this.imaginaryPart = number.div(complexNumber).imaginaryPart;
    }

    public ComplexNumber pow(double i) {
        ComplexNumber number = new ComplexNumber(this.realPart, this.imaginaryPart);
        number.realPart = Math.pow(number.length(), i) * Math.cos(number.arg() * i);
        number.imaginaryPart = Math.pow(number.length(), i) * Math.sin(number.arg() * i);
        return number;
    }

    public void pow2(double i) {
        ComplexNumber number = new ComplexNumber(this.realPart, this.imaginaryPart);
        this.realPart = number.pow(i).realPart;
        this.imaginaryPart = number.pow(i).imaginaryPart;
    }

    public boolean equals(Object other) {
        if (this.getClass() == other.getClass()) {
            ComplexNumber complexNumber = (ComplexNumber) other;
            return (this.getRealPart() == complexNumber.getRealPart() && this.getImaginaryPart() == complexNumber.getImaginaryPart());
        }
        return false;
    }

    public double length() {
        return Math.sqrt(this.realPart * this.realPart + this.imaginaryPart * this.imaginaryPart);
    }

    public double arg() {
        return Math.atan(this.imaginaryPart / this.realPart);
    }




}
