
import java.util.*;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double charge();
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }
@Override 
    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }
@Override 
    double charge() {
        return 80 + 15 * weight;
    }
@Override 
    public double insurance() {
        return value * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }
@Override 
    double charge() {
        return 40 + 10 * weight + 50;
    }
@Override 
    public double insurance() {
        return value * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double grandTotal = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double weight = sc.nextDouble();
                double value = sc.nextDouble();
                
                Parcel p;
                
                p = switch (type) {
                    case "STANDARD" -> new Standard(weight, value);
                    case "EXPRESS" -> new Express(weight, value);
                    default -> new Fragile(weight, value);
                };
                
                double charge = p.charge();
                double insurance = 0;
                
                if (p instanceof Insurable insurable) {
                    insurance = insurable.insurance();
                }
                
                double total = charge + insurance;
                
                System.out.printf(
                        "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                        type, charge, insurance, total);
                
                grandTotal += total;
            }
            
            System.out.printf("Grand Total: %.2f%n", grandTotal);
        }
    }
}
