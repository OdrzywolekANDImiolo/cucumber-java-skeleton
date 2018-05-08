package progob;

import java.util.List;

public interface IBank {
    List<Account> getClientAccounts(Client client);
    Account createAccount(Account clientAccount);
    double deposit(Account toAccount, double amount);
    double transfer(Account fromAccount, Account toAccount, double amount);
    double withdraw(Account fromAccount, double amount);
}
