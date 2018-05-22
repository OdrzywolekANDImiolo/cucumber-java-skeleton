package progob;

import cucumber.api.java.en.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DepositsManagementStepdefs {

    private Client client;
    private Account account1;
    private List<Double> clientDeposits;

    @Given("^a customer has an account with balance (\\d+)$")
    public void a_customer_has_an_account_with_balance(double balance) {
        client = new Client("Adam", "Nowak");
        account1 = new Account(client);
        account1.addBalance(balance);
        assertEquals(balance, account1.getBalance(), 0.001);
    }

    @When("^he opens a deposit with balance (\\d+)$")
    public void he_opens_a_deposit_with_balance(double amount) {
        account1.createDeposit(amount);
    }

    @Then("^he owns a deposit with balance (\\d+)$")
    public void he_owns_a_deposit_with_balance(double depositBalance) {
        clientDeposits= account1.getClientDeposits();
        assertEquals(1, clientDeposits.size());
        assertEquals(depositBalance , clientDeposits.get(0),0.001);

    }

    @Then("^the account has balance (\\d+)$")
    public void the_account_has_balance(double balance)
    {
        assertEquals(balance, account1.getBalance(), 0.001);

    }

}
