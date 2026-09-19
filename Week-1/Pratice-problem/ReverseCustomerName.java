import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }
        return new StringBuilder(customerName).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String customerName = scan.nextLine();
        
        String reversedName = reverseCustomerName(customerName);
        
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
        
        scan.close();
    }
}