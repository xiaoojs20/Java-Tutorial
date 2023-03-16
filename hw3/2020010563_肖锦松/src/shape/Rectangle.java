package shape;

public class Rectangle extends Shape {
    public double width, height;
    Rectangle() {
        this.shapeName = "Rectangle";
    }

    Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
        super.shapeWidth = w;
        super.shapeHeight = h;
        this.shapeName = "Rectangle";
    }

    Rectangle(double w, double h, String color) {
        super(color);
        this.width = w;
        this.height = h;
        super.shapeWidth = w;
        super.shapeHeight = h;
        this.shapeName = "Rectangle";
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double newW) {
        this.width = newW;
        super.shapeWidth = newW;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double newH) {
        this.height = newH;
        super.shapeHeight = newH;
    }

    public double getArea() {
        double S = this.height * this.width;
        return S;
    }

    public double getPerimeter() {
        double C = 2 * (this.height + this.width);
        return C;
    }

    public String toString() {
        String tmp;
        if (isFilled()) {
            tmp = "Rectangle " + "(" + this.color + ")";
        } else {
            tmp = "Rectangle " + "(#)";
        }
        return tmp;
    }
}
