public class BankReferenceTest {

    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed.toUpperCase();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        String ref = normalizeReference(reference);
        if (ref.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(ref.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(ref.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        String bankCode = ref.substring(0, 3);
        String datePart = ref.substring(3, 9);
        String formattedDate = datePart.substring(0, 2) + "/" + datePart.substring(2, 4) + "/" + datePart.substring(4, 6);
        String seq = ref.substring(9, 14);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ").append(formattedDate).append(" | SEQ: ").append(seq);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat("hdf03022600042"));
        System.out.println(validateAndFormat("12F03022600042"));
    }
}