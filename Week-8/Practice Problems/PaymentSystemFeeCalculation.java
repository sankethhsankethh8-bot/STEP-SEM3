
import java.util.*;

abstract class Payment {
    abstract double calculate(double amount);
}

class Card extends Payment {
    @Override 
    double calculate(double amount) {
        return amount * 1.02;
    }
}

class Wallet extends Payment {
    @Override
    double calculate(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer extends Payment {
    @Override
    double calculate(double amount) {
        return amount;
    }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double amount = sc.nextDouble();
                
                Payment p;
                p = switch (type) {
                    case "CARD" -> new Card();
                    case "WALLET" -> new Wallet();
                    default -> new BankTransfer();
                };
                
                double result = p.calculate(amount);
                System.out.printf("%s: %.2f%n", type, result);
                total += result;
            }
            
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
