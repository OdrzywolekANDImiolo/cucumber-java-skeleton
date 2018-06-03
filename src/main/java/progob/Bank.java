package progob;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bank implements IBank {
    private Set<Account> accounts;
    private Set<Deposit> deposits;


    public Bank()
    {
        accounts = new HashSet<>();
        deposits = new HashSet<>();
    }
    public Bank(Set<Account> accountRepository)
    {
        this.accounts = accountRepository;
       // this.deposits = depositRepository;
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

    @Override
    public void createDeposit(Deposit clientDeposit) {
        deposits.add(clientDeposit);
    }

    @Override
    public List<Deposit> getClientDeposits(Client client) {  //TO DO
        ArrayList<Deposit> listClientDeposits= new ArrayList<>();
        for(Deposit d: deposits)
        {
            if(client.getClientId() == d.getClientId())
            {
                listClientDeposits.add(d);
            }
        }
       return listClientDeposits;
    }

}
