public class NameTag {
    private final String firstName;
    private final String lastNameInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastNameInitial = String.valueOf(parts[1].charAt(0));
    }

    public String getNickname() {
        return firstName + " " + lastNameInitial + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}