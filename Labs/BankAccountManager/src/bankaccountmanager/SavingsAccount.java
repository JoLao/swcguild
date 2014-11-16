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
public class SavingsAccount extends Account {
    private double interestRate;
    private final double WITHDRAWAL_FEE = 1.00;

    
    //result
    //0     -> successful deposit
    //-1    -> depositing 10,000 or more    
    public int deposit(double money) {
        int result = super.deposit(money);
        double interest = balance * interestRate / 100;
        balance += interest;
        availableBalance += interest;
        return result;
    }

    //result
    //0      -> successful withdrawal        
    //-1     -> withdraw not allowed
    public int withdraw(double money) {
        int result = 0;
        
        if ((money+WITHDRAWAL_FEE) > this.availableBalance) {
            result = -1;
        } else {
            balance -= (money + WITHDRAWAL_FEE);
            availableBalance -= (money + WITHDRAWAL_FEE);
            result = 0;
        }
        return result;
    }

    public double getWithdrawalFee() {
        return WITHDRAWAL_FEE;
    }
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    
}
