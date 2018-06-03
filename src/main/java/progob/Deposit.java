package progob;

public class Deposit {
    Account account;
    double balance;
    public Deposit(Account account, double amount) throws WithdrawException
    {
        this.account = account;
        if (amount > account.getBalance()) {
            throw new WithdrawException("Not enough money on account");
        }
        else
        {
            this.balance = amount;
            account.withdraw(amount);
        }
    }
    public double getBalance()
    {  //TO DO
        return balance;
    }
    public int getClientId(){
        return account.getClientId();
    }
}
