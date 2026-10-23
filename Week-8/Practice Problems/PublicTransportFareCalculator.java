
import java.util.*;

abstract class Transport {
    abstract double fare(double distance, double factor);
}

class Bus extends Transport {
    @Override 
    double fare(double d, double f) {
        return Math.min(10, 2 + 0.10 * d);
    }
}

class Train extends Transport {
    @Override 
    double fare(double d, double f) {
        return 3 + 0.15 * d;
    }
}

class Metro extends Transport {
    @Override
    double fare(double d, double f) {
        return (1.5 + 0.20 * d) * f;
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double distance = sc.nextDouble();
                double factor = 1;
                
                Transport t;
                switch (type) {
                    case "BUS" -> t = new Bus();
                    case "TRAIN" -> t = new Train();
                    default -> {
                        t = new Metro();
                        factor = sc.nextDouble();
                    }
                }
                
                double amount = t.fare(distance, factor);
                System.out.printf("%s: %.2f%n", type, amount);
                total += amount;
            }
            
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
