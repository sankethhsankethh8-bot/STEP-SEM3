
import java.util.*;

abstract class Delivery {
    abstract double calculate(double weight, double distance,
                              double customs);
}

class Standard extends Delivery {
    @Override 
    double calculate(double w, double d, double c) {
        return 5 + 0.5 * w + 0.1 * d;
    }
}

class Express extends Delivery {
    @Override 
    double calculate(double w, double d, double c) {
        return 15 + w + 0.2 * d;
    }
}

class International extends Delivery {
    @Override 
    double calculate(double w, double d, double c) {
        return 25 + 2 * w + 0.5 * d + c;
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double weight = sc.nextDouble();
                double distance = sc.nextDouble();
                double customs = 0;
                
                Delivery delivery;
                switch (type) {
                    case "STANDARD" -> delivery = new Standard();
                    case "EXPRESS" -> delivery = new Express();
                    default -> {
                        delivery = new International();
                        customs = sc.nextDouble();
                    }
                }
                
                double fee = delivery.calculate(
                        weight, distance, customs);
                
                System.out.printf("%s: %.2f%n", type, fee);
                total += fee;
            }
            
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
