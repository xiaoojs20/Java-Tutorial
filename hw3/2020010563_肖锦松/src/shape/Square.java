package shape;

public class Square extends Rectangle {
    public double side;
    Square() {
        this.shapeName = "Square";
    }

    Square(double a) {
        super(a, a);
        super.shapeSide = a;
        this.side = a;
        this.shapeName = "Square";
    }

    Square(double a, String color) {
        super(a, a, color);
        super.shapeSide = a;
        this.side = a;
        this.shapeName = "Square";
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double newA) {
        super.height = newA;
        super.width = newA;
        super.shapeHeight = newA;
        super.shapeWidth = newA;
        this.side = newA;
        super.shapeSide = newA;
    }

    public double getArea() {
        double S = this.side * this.side;
        return S;
    }

    public double getPerimeter() {
        double C = 4 * this.side;
        return C;
    }

    public String toString() {
        String tmp;
        if (isFilled()) {
            tmp = "Square " + "(" + this.color + ")";
        } else {
            tmp = "Square " + "(#)";
        }
        return tmp;
    }
}
