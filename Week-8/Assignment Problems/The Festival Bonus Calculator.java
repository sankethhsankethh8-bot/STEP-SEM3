
import java.util.*;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) {
        super(name, salary);
    }
@Override 
    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime extends Employee {
    PartTime(String name, double salary) {
        super(name, salary);
    }
@Override 
    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }
@Override 
    double calculateBonus() {
        return 2000;
    }
}
@SuppressWarnings("unused")
class FestivalBonusCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                double salary = sc.nextDouble();
                
                Employee e;
                
                e = switch (type) {
                    case "FULLTIME" -> new FullTime(name, salary);
                    case "PARTTIME" -> new PartTime(name, salary);
                    default -> new Intern(name, salary);
                };
                
                double bonus = e.calculateBonus();
                
                System.out.printf("%s: %.2f%n", e.name, bonus);
                total += bonus;
            }
            
            System.out.printf("Total Bonus: %.2f%n", total);
        }
    }
}
