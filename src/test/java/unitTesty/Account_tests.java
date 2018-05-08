package unitTesty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import progob.Account;
import progob.Client;

import static org.junit.Assert.assertEquals;


public class Account_tests {
    private Account konto;
    @Before
    public void setup() {
        Client klient = new Client("Kamil", "Nowak");
        konto = new Account(klient);
    }
    @Test
    public void testInitbalance() {
        assertEquals(0, konto.getBalance(),0);
    }
    @Test
    public void testAddBalance() {
        konto.addBalance(20);
        assertEquals(20.0, konto.getBalance(),0);
    }
    @Test(expected = Exception.class)
    public void testWithdraw() {
        konto.addBalance(20);
        konto.withdraw(10);
        assertEquals(10, konto.getBalance(),0);
        konto.withdraw(20);
    }

}
