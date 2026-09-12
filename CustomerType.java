import java.util.Scanner;

public class CustomerType {
    
    public static String checkCustomer(String customerId) {
        if (customerId != null && customerId.startsWith("VIP")) {
            return "VIP Customer";
        }
        return "Regular Customer";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter Customer ID: ");
        String customerId = scan.nextLine();
        
        String result = checkCustomer(customerId);
        System.out.println("Customer Status: " + result);
        
        scan.close();
    }
}