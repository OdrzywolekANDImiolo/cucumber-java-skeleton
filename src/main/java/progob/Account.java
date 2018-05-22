package progob;

import java.util.*;


public class Account {
    private Client client;
    private double balance;


    public Account(Client client) {
        this.client = client;
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws WithdrawException{

        if (amount> balance) {
            throw new WithdrawException("Not enough money on account");
        }
        else
        {
            balance -= amount;
        }
    }
    public int getClientId(){
        return client.getClientId();
    }


    public List<Double> getClientDeposits() {
        ArrayList<Double> lista= new ArrayList<>();
        return lista;
    }

    public void createDeposit(double amount) {
    }
}
