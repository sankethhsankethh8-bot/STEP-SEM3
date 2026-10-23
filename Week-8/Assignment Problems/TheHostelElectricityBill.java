
import java.util.*;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Single extends Room {
    Single(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8;
    }
}

class Shared extends Room {
    int occupants;

    Shared(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AC extends Room {
    AC(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 10 + 200;
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int units = sc.nextInt();
                
                Room r;
                
                switch (type) {
                    case "SINGLE" -> r = new Single(units);
                    case "SHARED" -> {
                        int occupants = sc.nextInt();
                        r = new Shared(units, occupants);
                    }
                    default -> r = new AC(units);
                }
                
                double bill = r.calculateBill();
                
                System.out.printf("%s: %.2f%n", type, bill);
                total += bill;
            }
            
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
