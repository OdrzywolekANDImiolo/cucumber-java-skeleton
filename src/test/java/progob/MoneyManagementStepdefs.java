package progob;


import cucumber.api.java.en.*;

public class MoneyManagementStepdefs {
    private Account accountA,
            accountB;


    @Given("^balance on account A is (.+)$")
    public void balance_on_account_A_is(double balance) {
        accountA.deposit(balance);
    }

    @Given("^balance on account B is (.+)$")
    public void balance_on_account_B_is(double balance) {
        accountB.deposit(balance);
    }

    @When("^(.+) is transfered from account A to B$")
    public void is_transfered_from_account_A_to_B(double amount) {
        accountA.transfer(accountB, amount);
    }

    @When("^customer deposits (.+) to account A$")
    public void customer_deposits_to_account_A(double amount) {
        accountA.deposit(amount);
    }

    @When("^customer withdrawns (.+) from account A$")
    public void customer_withdrawns_from_account_A(double amount) {
        accountA.withdraw(amount);
    }
}
