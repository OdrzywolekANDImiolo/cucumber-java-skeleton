package progob;

import cucumber.api.java.en.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AccountsManagementStepdefs {

    private IBank bank;
    private Set<Account> accountRepository;
    private Client client;
    private List<Account> clientAccounts;
    private Account newClientAccount;

    @Given("^a customer has two accounts open$")
    public void a_customer_has_two_accounts_open() {
        client = new Client("Adam", "Nowak");
        Account account1 = new Account(client);
        Account account2 = new Account(client);
        accountRepository = new HashSet<>();
        accountRepository.add(account1);
        accountRepository.add(account2);
        bank = new MemoryBank(accountRepository);
    }

    @When("^he lists his accounts$")
    public void he_lists_his_accounts() {
        clientAccounts = bank.getClientAccounts(client);
    }

    @Then("^both of them are on the list$")
    public void both_of_them_are_on_the_list() {
        assertEquals(2, clientAccounts.size());
    }

    @Given("^a customer wants to open an account$")
    public void a_customer_wants_to_open_an_account() {
        client = new Client("Andrzej", "Kowalski");
        newClientAccount = new Account(client);

    }

    @When("^his account is created$")
    public void his_account_is_created() {
        bank.createAccount(newClientAccount);
    }

    @Then("^there is a new account on his account list$")
    public void there_is_a_new_account_on_his_account_list() {
        clientAccounts = bank.getClientAccounts(client);
        assertEquals(1, clientAccounts.size());
    }

    @Then("^the balance on his account is (\\d+)$")
    public void the_balance_on_his_account_is(int balance) {
        assertEquals(balance, clientAccounts.get(0).getBalance(), 0.001);
    }
}