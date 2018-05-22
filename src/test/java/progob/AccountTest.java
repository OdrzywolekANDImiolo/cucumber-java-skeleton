package progob;

import org.junit.Before;
import org.junit.Test;
import progob.Account;
import progob.Client;
import progob.WithdrawException;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class AccountTest {
    private Account konto;
    private List<Double> clientDeposits;
    @Before
    public void setup() {
        Client klient = new Client("Kamil", "Nowak");
        konto = new Account(klient);
        List<Double> clientDeposits= new ArrayList<>();
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
    @Test
    public void testDeposits() throws WithdrawException {
        konto.addBalance(100);
        konto.createDeposit(50);
        konto.createDeposit(40);
        assertEquals(10.0, konto.getBalance(),0);
    }
    @Test
    public void testCountDeposits() throws WithdrawException {
        konto.addBalance(100);
        clientDeposits= konto.getClientDeposits();
        assertEquals(0, clientDeposits.size());
        konto.createDeposit(50);
        konto.createDeposit(40);
        assertEquals(2, clientDeposits.size());
        assertEquals(true , clientDeposits.contains(40));
        assertEquals(true , clientDeposits.contains(50));

    }

}
