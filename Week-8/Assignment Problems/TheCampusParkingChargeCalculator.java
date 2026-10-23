
import java.util.*;

abstract class Vehicle {
    abstract double calculateCharge(int hours);
}

class Bike extends Vehicle {
    @Override 
    double calculateCharge(int hours) {
        return hours * 10;
    }
}

class Car extends Vehicle {
    @Override 
    double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    @Override 
    double calculateCharge(int hours) {
        return Math.max(100, hours * 50);
    }
}

public class TheCampusParkingChargeCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int hours = sc.nextInt();
                
                Vehicle v;
                
                v = switch (type) {
                    case "BIKE" -> new Bike();
                    case "CAR" -> new Car();
                    default -> new Truck();
                };
                
                double charge = v.calculateCharge(hours);
                
                System.out.printf("%s: %.2f%n", type, charge);
                total += charge;
            }
            
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
