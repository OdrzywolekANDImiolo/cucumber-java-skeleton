package progob;


import cucumber.api.java.en.*;

import java.util.HashSet;
import java.util.Set;

public class MoneyManagementStepdefs {
    private Set<Account> accountRepository = new HashSet<>();
    private IBank bank = new Bank(accountRepository);
    private Client client1 = new Client("Adam", "Kowalski");
    private Client client2 = new Client("Andrzej", "Nowak");
    private Account accountA,
            accountB;


    @Given("^balance on account A is (.+)$")
    public void balance_on_account_A_is(double balance) {
        accountA = new Account(client1);
        bank.createAccount(accountA);
        bank.deposit(accountA, balance);
    }

    @Given("^balance on account B is (.+)$")
    public void balance_on_account_B_is(double balance) {
        accountB = new Account(client2);
        bank.createAccount(accountB);
        bank.deposit(accountB, balance);
    }

    @When("^(.+) is transfered from account A to B$")
    public void is_transfered_from_account_A_to_B(double amount) {
        bank.transfer(accountA, accountB, amount);
    }

    @When("^customer deposits (.+) to account A$")
    public void customer_deposits_to_account_A(double amount) {
        bank.deposit(accountA, amount);
    }

    @When("^customer withdrawns (.+) from account A$")
    public void customer_withdrawns_from_account_A(double amount) {
        bank.withdraw(accountA, amount);
    }
}