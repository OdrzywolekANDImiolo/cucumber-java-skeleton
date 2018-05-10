package progob;

import org.junit.Before;
import org.junit.Test;
import progob.Account;
import progob.Client;
import progob.WithdrawException;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class AccountTest {
    private Account konto;
    @Before
    public void setup() {
        Client klient = new Client("Kamil", "Nowak");
        konto = new Account(klient);
    }
    @Test
    public void testEqualsNullIsFalse() {
        assertFalse(konto.equals(null));
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
    @Test
    public void testWithdraw() throws WithdrawException {
        konto.addBalance(20);

        try {
            konto.withdraw(10);
            assertEquals(10, konto.getBalance(), 0);
            konto.withdraw(20);
            fail();
        }
        catch (WithdrawException e)
        {}
    }

}
