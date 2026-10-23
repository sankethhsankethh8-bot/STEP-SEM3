
import java.time.*;
import java.util.*;

abstract class LibraryItem {
    abstract int getDays();

    LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getDays());
    }
}

class Book extends LibraryItem {
    @Override 
    int getDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    @Override
    int getDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    @Override
    int getDays() {
        return 3;
    }
}

public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                String[] parts = line.split("\\s+", 2);
                String type = parts[0];
                String title = parts[1].trim();
                
                if (title.startsWith("\"") &&
                        title.endsWith("\"")) {
                    title = title.substring(1, title.length() - 1);
                }
                
                LibraryItem item;
                item = switch (type) {
                    case "BOOK" -> new Book();
                    case "DVD" -> new DVD();
                    default -> new Magazine();
                };
                
                System.out.println(title + ": " + item.dueDate());
            }
        }
    }
}
