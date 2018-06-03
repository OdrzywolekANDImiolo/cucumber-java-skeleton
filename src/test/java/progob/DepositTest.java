package progob;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;


public class DepositTest {
}
    private Account konto;
    private Deposit deposit;
    @Before
    public void setup() {
        Client klient = new Client("Kamil", "Nowak");
        konto = new Account(klient);
    }

    @Test
    public void testCreateDeposit() throws WithdrawException {
        konto.addBalance(100);
        deposit = new Deposit(konto, 60);
        assertEquals(40.0, konto.getBalance(),0);
        assertEquals(60.0, deposit.getBalance(),0);
        assertEquals(100, deposit.getBalance()+konto.getBalance(), 0);
    }
    @Test
    public void testDepositsNotEnoughMoney() throws WithdrawException {
        konto.addBalance(20);

        try {
            deposit = new Deposit(konto, 60);
            fail();
        }
        catch (WithdrawException e)
        {}
    }

}
