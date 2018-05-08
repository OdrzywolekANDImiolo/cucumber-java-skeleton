package unitTesty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import progob.Account;
import progob.Bank;
import progob.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class Bank_tests {

    Set<Account> zbiorKont;
    Bank bank;
    @Before
    public void setup() {
        zbiorKont=new HashSet<Account>();
        bank = new Bank(zbiorKont);
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
    public void testTransfer()
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
    public void testWithdraw1()
    {
        Account konto_Klienta = new Account(new Client("Kamil", "Nowak"));
        bank.createAccount(konto_Klienta);
        konto_Klienta.addBalance(50);
        bank.withdraw(konto_Klienta, 40);
        assertEquals(10, konto_Klienta.getBalance(),0);
    }
    @Test (expected = Exception.class)
    public void testWithdraw2()
    {
        Account konto_Klienta = new Account(new Client("Kamil", "Nowak"));
        bank.createAccount(konto_Klienta);
        konto_Klienta.addBalance(50);
        bank.withdraw(konto_Klienta, 70);
    }
    @Test
    public void testGetClientAccounts()
    {
        Client klient=new Client("Kamil", "Nowak");
        Account konto_Klienta1 = new Account(klient);
        Account konto_Klienta2 = new Account(klient);
        bank.createAccount(konto_Klienta1);
        bank.createAccount(konto_Klienta2);
        ArrayList listaKont = new ArrayList();
        listaKont.add(konto_Klienta1);
        listaKont.add(konto_Klienta2);
        assertTrue(bank.getClientAccounts(klient).equals(listaKont));
    }
}
