
import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
@Override 
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
@Override 
    double area() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
@Override 
    double area() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            Plot p;

            p = switch (type) {
                case "CIRCLE" -> new Circle(owner, sc.nextDouble());
                case "RECTANGLE" -> new Rectangle(owner,
                        sc.nextDouble(), sc.nextDouble());
                default -> new Triangle(owner,
                        sc.nextDouble(), sc.nextDouble());
            };

            double result = p.area();
            System.out.printf("%s (%s): %.2f%n",
                    p.owner, type, result);
            total += result;
        }

        System.out.printf("Total Area: %.2f%n", total);
        }
    }
}
