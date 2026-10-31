
import java.util.*;

interface BusUser {
    double BUS_FEE = 12000;

    default double transportFee() {
        return BUS_FEE;
    }
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    double totalFee() {
        double fee = tuition();

        if (this instanceof BusUser) {
            fee += ((BusUser) this).transportFee();
        }

        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double tuition() {
        return 20000;
    }
}

public class {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                
                Student s;
                
                s = switch (type) {
                    case "DAY_SCHOLAR" -> new DayScholar(name);
                    case "HOSTELLER" -> new Hosteller(name);
                    default -> new Scholar(name);
                };
                
                double fee = s.totalFee();
                
                System.out.printf("%s: %.2f%n", s.name, fee);
                total += fee;
            }
            
            System.out.printf("Total Collected: %.2f%n", total);
        }
    }
}
