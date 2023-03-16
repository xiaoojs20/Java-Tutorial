package shape;

public class Shapes {
    Shape[] shapes;
    double area = 0;
    double farea = 0;

    Shapes(Shape[] args) {
        this.shapes = args;
    }

    public double getArea() {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].shapeName == "Circle") {
                this.area += Math.PI * shapes[i].shapeRadius * shapes[i].shapeRadius;
            } else if (shapes[i].shapeName == "Rectangle") {
                this.area += shapes[i].shapeHeight * shapes[i].shapeWidth;
            } else if (shapes[i].shapeName == "Square") {
                this.area += shapes[i].shapeSide * shapes[i].shapeSide;
            }
        }
//        System.out.println(area);
        return area;
    }

    public double getFilledArea() {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].isFilled()) {
                if (shapes[i].shapeName == "Circle") {
                    this.farea += Math.PI * shapes[i].shapeRadius * shapes[i].shapeRadius;
                } else if (shapes[i].shapeName == "Rectangle") {
                    this.farea += shapes[i].shapeHeight * shapes[i].shapeWidth;
                } else if (shapes[i].shapeName == "Square") {
                    this.farea += shapes[i].shapeSide * shapes[i].shapeSide;
                }
            }
        }
//        System.out.println(farea);
        return farea;
    }

    public String toString() {
        String allShapes = "";
        allShapes = allShapes + "[";
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].isFilled()) {
                allShapes = allShapes + shapes[i].shapeName + " (" + shapes[i].color + ")";
            } else {
                allShapes = allShapes + shapes[i].shapeName + " (#)";
            }
            if (i != (shapes.length - 1)) {
                allShapes = allShapes + ", ";
            } else {
                allShapes = allShapes + "]";
            }
        }
        return allShapes;
    }
}
