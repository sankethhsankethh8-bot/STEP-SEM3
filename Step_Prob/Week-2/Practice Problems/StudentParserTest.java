public class StudentParserTest {

    
    public static void parseStudentRecord(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: " + parts[0].trim() + " | Roll No: " + parts[1].trim() + " | Dept: " + parts[2].trim());
    }

    
    public static void main(String[] args) {
    
        parseStudentRecord("Ananya Verma, RA2211003010123,CSE");

    
        parseStudentRecord("Ananya Verma,CSE");
    }
}
