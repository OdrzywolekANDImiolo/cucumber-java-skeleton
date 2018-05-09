package progob;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Bank implements IBank {
    private Set<Account> accounts;

    public Bank(Set<Account> accountRepository) {
        this.accounts = accountRepository;
    }

    @Override
    public List<Account> getClientAccounts(Client client) {
        ArrayList<Account> lista= new ArrayList<>();
        for(Account a: accounts)
        {
            if(client.getClientId()==a.getClientId())
            {
                lista.add(a);
            }
        }
        return lista;
    }

    @Override
    public Account createAccount(Account clientAccount) {
        accounts.add(clientAccount);
        return clientAccount;
    }

    @Override
    public void deposit(Account toAccount, double amount) {
        toAccount.addBalance(amount);
    }

    @Override
    public void transfer(Account fromAccount, Account toAccount, double amount) throws WithdrawException {
        fromAccount.withdraw(amount);
        toAccount.addBalance(amount);
    }

    @Override
    public void withdraw(Account fromAccount, double amount) throws WithdrawException{
        fromAccount.withdraw(amount);
    }
}
