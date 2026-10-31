
import java.util.*;

abstract class LibraryItem {
    String title;
    int days;

    LibraryItem(String title, int days) {
        this.title = title;
        this.days = days;
    }

    abstract double fine();
}

class Book extends LibraryItem {
    Book(String title, int days) {
        super(title, days);
    }

    @Override
    double fine() {
        return days * 2;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int days) {
        super(title, days);
    }
    @Override 
    double fine() {
        return Math.min(days * 5, 50);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int days) {
        super(title, days);
    }
    @Override 
    double fine() {
        return days;
    }
}

public class LibraryLateFine {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;
            
            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String title = sc.next();
                int days = sc.nextInt();
                
                LibraryItem item;
                
                item = switch (type) {
                    case "BOOK" -> new Book(title, days);
                    case "DVD" -> new DVD(title, days);
                    default -> new Magazine(title, days);
                };
                
                double amount = item.fine();
                System.out.printf("%s: %.2f%n",
                        item.title, amount);
                total += amount;
            }
            
            System.out.printf("Total Fines: %.2f%n", total);
        }
    }
}
