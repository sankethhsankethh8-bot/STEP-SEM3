
import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }
@Override 
    double pay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
@Override 
    double pay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
@Override 
    double pay() {
        return stipend;
    }
}

public class WeeklyStaff {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                
                Staff s;
                
                s = switch (type) {
                    case "FULLTIME" -> new FullTime(name, sc.nextDouble());
                    case "HOURLY" -> new Hourly(name,
                            sc.nextDouble(), sc.nextDouble());
                    default -> new Intern(name, sc.nextDouble());
                };
                
                double amount = s.pay();
                System.out.printf("%s: %.2f%n", s.name, amount);
                total += amount;
            }
            
            System.out.printf("Total Payroll: %.2f%n", total);
        }
    }
}
