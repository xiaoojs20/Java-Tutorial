package complex;
import java.text.DecimalFormat;

public class Complex {
    public double realPart, imaginaryPart;
    Complex(double re, double im){
        this.realPart = re;
        this.imaginaryPart = im;
    }
    public void add(Complex obj){
        this.realPart += obj.realPart;
        this.imaginaryPart += obj.imaginaryPart;
    }

    public void sub(Complex obj){
        this.realPart -= obj.realPart;
        this.imaginaryPart -= obj.imaginaryPart;
    }

    public void multi(Complex obj){
        double a = this.realPart;
        double b = this.imaginaryPart;
        double c = obj.realPart;
        double d = obj.imaginaryPart;
        this.realPart = a*c-b*d;
        this.imaginaryPart = a*d + b*c;
    }

    public void div(Complex obj){
        double a = this.realPart;
        double b = this.imaginaryPart;
        double c = obj.realPart;
        double d = obj.imaginaryPart;

        this.realPart = (a*c + b*d)/(c*c + d*d);
        this.imaginaryPart = (b*c - a*d)/(c*c + d*d);
    }

    public String print() {
        DecimalFormat df = new DecimalFormat("0.000");
        String re = df.format(this.realPart);
        String im = df.format(this.imaginaryPart);
        String str = "";
        if(this.imaginaryPart < 0){
            str = re + im + "i";
        }else if(this.imaginaryPart >= 0){
            str = re + "+" + im + "i";
        }
        return str;
    }
}
