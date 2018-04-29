package progob;

import java.util.List;
import java.util.Set;

public class Bank implements IBank {
    private Set<Account> accounts;

    public Bank(Set<Account> accountRepository) {
        this.accounts = accountRepository;
    }

    @Override
    public List<Account> getClientAccounts(Client client) {
        return null;
    }

    @Override
    public Account createAccount(Account clientAccount) {
        return null;
    }

    @Override
    public double deposit(Account toAccount, double amount) {
        return 0;
    }

    @Override
    public double transfer(Account fromAccount, Account toAccount, double amount) {
        return 0;
    }

    @Override
    public double withdraw(Account fromAccount, double amount) {
        return 0;
    }
}
