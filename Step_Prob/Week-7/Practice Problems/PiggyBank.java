public class PiggyBank {
    private int savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
        }
    }

    public int getSavings() {
        return this.savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("savings = " + pb.getSavings());
    }
}