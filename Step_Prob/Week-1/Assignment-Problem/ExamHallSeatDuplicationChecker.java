public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    duplicateFound = true;
                    System.out.println("Duplicate seat number found: " + seatNumbers[i]);
                }
            }
        }
        if (!duplicateFound) {
            System.out.println("No duplicate seat numbers found.");
        }
    }

    public static void main(String[] args) {
        int[] seatNumbers = {12, 7, 19, 12, 25, 7};
        checkDuplicateSeats(seatNumbers);
    }
}