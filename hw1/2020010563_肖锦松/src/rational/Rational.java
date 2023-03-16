package rational;

public class Rational {
    int numerator, denominator;

    public static int GCD(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

    Rational(int m, int n) {
        this.numerator = m / GCD(m, n);
        this.denominator = n / GCD(m, n);
    }

    public Rational add(Rational r) {
        int gcd = GCD((this.numerator * r.denominator + this.denominator * r.numerator), (this.denominator * r.denominator));
        this.numerator = (this.numerator * r.denominator + this.denominator * r.numerator) / gcd;
        this.denominator = (this.denominator * r.denominator) / gcd;
        Rational tmp = new Rational(this.numerator, this.denominator);
        return tmp;
    }

    public Rational sub(Rational r) {
        int gcd = GCD((this.numerator * r.denominator - this.denominator * r.numerator), (this.denominator * r.denominator));
        this.numerator = (this.numerator * r.denominator - this.denominator * r.numerator) / gcd;
        this.denominator = (this.denominator * r.denominator) / gcd;
        Rational tmp = new Rational(this.numerator, this.denominator);
        return tmp;
    }

    public Rational mul(Rational r) {
        int gcd = GCD((this.numerator * r.numerator), (this.denominator * r.denominator));
        this.numerator = (this.numerator * r.numerator) / gcd;
        this.denominator = (this.denominator * r.denominator) / gcd;
        Rational tmp = new Rational(this.numerator, this.denominator);
        return tmp;
    }

    public Rational div(Rational r) {
        int gcd = GCD((this.numerator * r.denominator), (this.denominator * r.numerator));
        this.numerator = (this.numerator * r.denominator) / gcd;
        this.denominator = (this.denominator * r.numerator) / gcd;
        Rational tmp = new Rational(this.numerator, this.denominator);
        return tmp;
    }
    // 打印分数
    public void printRational() {
        if (this.denominator == 1) {
            String Rational_str = String.valueOf(this.numerator);
            System.out.println(Rational_str);
        } else {
            String Rational_str = String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
            System.out.println(Rational_str);
        }
    }
    // 打印实数
    public void printReal() {
        float real = (float) this.numerator / (float) this.denominator;
        System.out.println(real);
    }

}
