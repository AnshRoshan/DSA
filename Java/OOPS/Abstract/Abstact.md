# Abstract class

An abstract class in Java is a class that cannot be instantiated on its own, but it can contain both abstract and concrete methods. Abstract classes serve as blueprints for other classes, providing a common interface and partial implementation that subclasses can extend and implement. Here's a detailed explanation along with some Java code:

### Definition:

An abstract class is declared using the `abstract` keyword. It can have abstract methods (methods without a body) as well as concrete methods (methods with a body). Abstract classes cannot be instantiated directly, meaning you cannot create objects of abstract classes. Instead, you must create subclasses that extend the abstract class and provide implementations for the abstract methods.

### Example:

Let's consider an example of an abstract class `Shape`, which defines the common properties and behaviors of all shapes. We'll have an abstract method `calculateArea()` that each subclass must implement, and a concrete method `printArea()` that prints the area of the shape.

```java
// Abstract class
abstract class Shape {
    // Abstract method to calculate area
    public abstract double calculateArea();

    // Concrete method to print area
    public void printArea() {
        System.out.println("Area: " + calculateArea());
    }
}

// Subclass Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementation of abstract method
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementation of abstract method
    public double calculateArea() {
        return length * width;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating objects of Circle and Rectangle
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        // Calling methods
        circle.printArea();     // Output: Area: 78.53981633974483
        rectangle.printArea();  // Output: Area: 24.0
    }
}
```

### Explanation:

- `Shape` is an abstract class that defines the `calculateArea()` method as abstract. This means any subclass of `Shape` must provide an implementation for `calculateArea()`.
- `Circle` and `Rectangle` are concrete subclasses of `Shape`. They provide implementations for `calculateArea()`.
- The `printArea()` method is implemented in the abstract class `Shape`. It calls `calculateArea()` to get the area and prints it.
- In the `Main` class, objects of `Circle` and `Rectangle` are created and their `printArea()` methods are called, demonstrating polymorphism and the use of abstract classes in Java.