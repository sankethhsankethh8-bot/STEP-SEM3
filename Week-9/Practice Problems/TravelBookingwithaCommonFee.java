
import java.util.*;

abstract class Booking {
    double distance;
    static final double BOOKING_FEE = 50;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }
@Override 
    double baseFare() {
        return distance * 2;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }
@Override 
    double baseFare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }
@Override 
    double baseFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBookingwithaCommonFee {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double distance = sc.nextDouble();
                
                Booking b;
                
                b = switch (type) {
                    case "BUS" -> new Bus(distance);
                    case "TRAIN" -> new Train(distance);
                    default -> new Flight(distance);
                };
                
                System.out.printf("%s: %.2f%n",
                        type, b.totalFare());
            }
        }
    }
}
