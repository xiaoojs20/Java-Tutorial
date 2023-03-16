package shape;

abstract class Shape {
    public String color;
    public String shapeName;
    public double shapeRadius, shapeHeight, shapeWidth, shapeSide;
    Shape() {

    }

    Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public boolean isFilled() {
        if (this.color != null) {
            return true;
        } else {
            return false;
        }
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract String toString();

}
