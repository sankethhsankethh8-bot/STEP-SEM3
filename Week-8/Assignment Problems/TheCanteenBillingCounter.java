
import java.util.*;

abstract class Customer {
    abstract double calculateBill(double amount);
}

class Student extends Customer {
    @Override 
    double calculateBill(double amount) {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    @Override
    double calculateBill(double amount) {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    @Override 
    double calculateBill(double amount) {
        return amount + 10;
    }
}

public class TheCanteenBillingCounter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double amount = sc.nextDouble();
                
                Customer c;
                
                c = switch (type) {
                    case "STUDENT" -> new Student();
                    case "STAFF" -> new Staff();
                    default -> new Guest();
                };
                
                double bill = c.calculateBill(amount);
                System.out.printf("%s: %.2f%n", type, bill);
                total += bill;
            }
            
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
