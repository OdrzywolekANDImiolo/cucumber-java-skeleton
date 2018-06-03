package progob;

import cucumber.api.java.en.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DepositsManagementStepdefs {

    private IBank bank;
    private Client client;
    private Account account;
    private Deposit deposit;
    private List<Deposit> clientDeposits;

    @Given("^a customer has an account with balance (\\d+)$")
    public void a_customer_has_an_account_with_balance(double balance) {
        client = new Client("Adam", "Nowak");
        account = new Account(client);
        account.addBalance(balance);
        bank = new Bank();
        bank.createAccount(account);
        assertEquals(balance, account.getBalance(), 0.001);
    }

    @When("^he opens a deposit with balance (\\d+)$")
    public void he_opens_a_deposit_with_balance(double amount) throws WithdrawException {
        deposit = new Deposit(account, amount);
        bank.createDeposit(deposit);
        assertEquals(amount , deposit.getBalance(),0.001);
    }

    @Then("^he owns a deposit with balance (\\d+)$")
    public void he_owns_a_deposit_with_balance(double depositBalance) {
        clientDeposits= bank.getClientDeposits(client);
        assertEquals(1, clientDeposits.size());
        assertEquals(depositBalance , clientDeposits.get(0).getBalance(),0.001);
    }

    @Then("^the account has balance (\\d+)$")
    public void the_account_has_balance(double balance)
    {
        assertEquals(balance, account.getBalance(), 0.001);

    }

}
