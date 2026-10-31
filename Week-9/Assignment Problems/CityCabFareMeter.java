
import java.util.*;

interface NightService {
    default double nightFare(double fare) {
        return fare * 1.20;
    }
}

abstract class Cab {
    abstract double rate();

    double fare(double km) {
        return Math.max(100, km * rate());
    }
}
@
class Mini extends Cab {
    double rate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    double rate() {
        return 14;
    }
}

class SUV extends Cab implements NightService {
    double rate() {
        return 18;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double km = sc.nextDouble();
                String time = sc.next();
                
                Cab cab;
                
                cab = switch (type) {
                    case "MINI" -> new Mini();
                    case "SEDAN" -> new Sedan();
                    default -> new SUV();
                };
                
                if (time.equals("NIGHT") &&
                        !(cab instanceof NightService)) {
                    System.out.println(
                            type + ": night service not available");
                    continue;
                }
                
                double fare = cab.fare(km);
                
                if (time.equals("NIGHT")) {
                    fare = ((NightService) cab).nightFare(fare);
                }
                
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
            
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
