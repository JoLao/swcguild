/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountmanager;

/**
 *
 * @author apprentice
 */
public class Account {

    protected String name;
    protected String atmNbr;
    protected String accountNbr;
    protected String accountType;
    protected double balance;
    protected double availableBalance;
    protected String pin;

    //result
    //0     -> successful deposit
    //-1    -> depositing 10,000 or more
    public int deposit(double money) {
        int result = 0;

        if (money >= 10000) {
            result = -1;
        } else {
            availableBalance += money;
            result = 0;
        }
        balance += money;
        return result;
    }

    //result
    //0      -> successful withdrawal        
    //-1     -> withdraw not allowed
    public int withdraw(double money) {
        int result = 0;

        if (money > this.availableBalance) {
            result = -1;
        } else {
            balance -= money;
            availableBalance -= money;
            result = 0;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAtmNbr() {
        return atmNbr;
    }

    public void setAtmNbr(String atmNbr) {
        this.atmNbr = atmNbr;
    }

    public String getAccountNbr() {
        return accountNbr;
    }

    public void setAccountNbr(String accountNbr) {
        this.accountNbr = accountNbr;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}
