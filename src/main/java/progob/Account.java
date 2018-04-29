package progob;

public class Account {
    private Client client;
    private double balance;

    public Account(Client client) {
        this.client = client;
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double addBalance(double balance) {
        return 0;
    }

    public double withdraw(double amount) {
        return 0;
    }


}
