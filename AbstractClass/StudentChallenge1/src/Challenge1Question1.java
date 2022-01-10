abstract class Shape {
    abstract public double calcPerimeter();

    abstract public double calcArea();
}

class Circle extends Shape {
    public double radius;

    public Circle() {
        radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calcPerimeter() {
        double perimeter = 2 * Math.PI * radius;

        return perimeter;
    }

    public double calcArea() {
        double area = Math.PI * radius * radius;

        return area;
    }
}

class Rectangle extends Shape {
    public double length, breadth;

    public Rectangle() {
        length = 1;
        breadth = 1;
    }

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double calcPerimeter() {
        double perimeter = 2 * (length + breadth);

        return perimeter;
    }

    public double calcArea() {
        double area = length * breadth;

        return area;
    }
}

public class Challenge1Question1 {

    public static void main(String[] args) {
        Shape s1, s2;

        s1 = new Circle(3);
        s2 = new Rectangle(3, 4);

        System.out.println("Circle:\nPerimeter = " + s1.calcPerimeter() + "\nArea = " + s1.calcArea());
        System.out.println("\nRectangle:\nPerimeter = " + s2.calcPerimeter() + "\nArea = " + s2.calcArea());

    }
}
