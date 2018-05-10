package progob;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;


public class BankTest {

    Set<Account> zbiorKont;
    Bank bank;
    @Before
    public void setup() {
        zbiorKont=new HashSet<Account>();
        bank = new Bank(zbiorKont);
    }
    @Test
    public void testEqualsNullIsFalse() {
        assertFalse(bank.equals(null));
    }
    @Test
    public void testCreateAccounts()
    {
        Account konto_Klienta = new Account(new Client("Kamil", "Nowak"));
        bank.createAccount(konto_Klienta);
        assertTrue(zbiorKont.contains(konto_Klienta));
    }
    @Test
    public void testDeposit()
    {
        Account konto_Klienta = new Account(new Client("Kamil", "Nowak"));
        bank.createAccount(konto_Klienta);
        bank.deposit(konto_Klienta, 50);
        assertEquals(50, konto_Klienta.getBalance(),0);
    }
    @Test
    public void testTransfer()  throws WithdrawException
    {
        Account konto_Klienta = new Account(new Client("Kamil", "Nowak"));
        Account konto_Klienta2 = new Account(new Client("Piotr", "Noga"));
        bank.createAccount(konto_Klienta);
        bank.createAccount(konto_Klienta2);
        konto_Klienta.addBalance(50);
        assertEquals(50, konto_Klienta.getBalance(),0);
        assertEquals(0, konto_Klienta2.getBalance(),0);
        bank.transfer(konto_Klienta, konto_Klienta2, 50);
        assertEquals(0, konto_Klienta.getBalance(),0);
        assertEquals(50, konto_Klienta2.getBalance(),0);
    }
    @Test
    public void testWithdraw1()  throws WithdrawException
    {
        Account konto_Klienta = new Account(new Client("Kamil", "Nowak"));
        bank.createAccount(konto_Klienta);
        konto_Klienta.addBalance(50);
        bank.withdraw(konto_Klienta, 40);
        assertEquals(10, konto_Klienta.getBalance(),0);
    }
    @Test
    public void testWithdraw2()  throws WithdrawException
    {
        Account konto_Klienta = new Account(new Client("Kamil", "Nowak"));
        bank.createAccount(konto_Klienta);
        konto_Klienta.addBalance(50);
        try {
            bank.withdraw(konto_Klienta, 70);
            fail();
        }
        catch (WithdrawException e)
        {}

    }
    @Test
    public void testGetClientAccounts()
    {
        Client klient1=new Client("Kamil", "Nowak");
        Client klient2=new Client("Kamil", "Nowak");
        Account konto_Klienta1 = new Account(klient1);
        Account konto_Klienta2 = new Account(klient1);
        Account konto_Klienta3 = new Account(klient2);
        bank.createAccount(konto_Klienta1);
        bank.createAccount(konto_Klienta2);
        bank.createAccount(konto_Klienta3);
        ArrayList listaKont = new ArrayList();
        listaKont.add(konto_Klienta1);
        listaKont.add(konto_Klienta2);
        listaKont.add(konto_Klienta3);
        assertTrue(bank.getClientAccounts(klient1).contains(konto_Klienta1));
        assertTrue(bank.getClientAccounts(klient1).contains(konto_Klienta2));
        assertFalse(bank.getClientAccounts(klient1).contains(konto_Klienta3));
    }
}
