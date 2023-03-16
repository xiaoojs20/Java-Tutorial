package shape;

public class Circle extends Shape {
    public double radius;
    Circle() {
        this.shapeName = "Circle";
    }

    Circle(double r) {
        this.radius = r;
        super.shapeRadius = r;
        this.shapeName = "Circle";
    }

    Circle(double r, String color) {
        this.radius = r;
        super.shapeRadius = r;
        this.color = color;
        this.shapeName = "Circle";
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double newR) {
        this.radius = newR;
        super.shapeRadius = newR;
    }

    public double getArea() {
        double S = Math.PI * this.radius * this.radius;
        return S;
    }

    public double getPerimeter() {
        double C = 2 * Math.PI * this.radius;
        return C;
    }

    public String toString(){
        String tmp;
        if(isFilled()) {
            tmp = "Circle " + "(" + this.color + ")";
        }else{
            tmp = "Circle " + "(#)";
        }
        return tmp;
    }
}
