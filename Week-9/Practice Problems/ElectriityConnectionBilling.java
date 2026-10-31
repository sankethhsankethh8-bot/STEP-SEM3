
import java.util.*;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(int units) {
        super(units);
    }
@Override 
    double bill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(int units) {
        super(units);
    }
@Override 
    double bill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(int units) {
        super(units);
    }
@Override 
    double bill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectriityConnectionBilling {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int units = sc.nextInt();
                
                Connection c;
                
                c = switch (type) {
                    case "HOME" -> new Home(units);
                    case "SHOP" -> new Shop(units);
                    default -> new Factory(units);
                };
                
                double amount = c.bill();
                System.out.printf("%s: %.2f%n", type, amount);
                total += amount;
            }
            
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
