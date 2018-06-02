package progob;

import java.util.List;

public interface IBank {
    List<Account> getClientAccounts(Client client);
    public Account createAccount(Account clientAccount);
    void deposit(Account toAccount, double amount);
    void transfer(Account fromAccount, Account toAccount, double amount) throws WithdrawException;
    void withdraw(Account fromAccount, double amount) throws WithdrawException;

    void createDeposit(Deposit deposit);
    List<Deposit> getClientDeposits(Client client);
}
