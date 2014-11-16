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
public class Client {
    private String name;
    
    private SavingsAccount  savings;
    private CheckingAccount checking;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SavingsAccount getSavings() {
        return savings;
    }

    public void setSavings(SavingsAccount savings) {
        this.savings = savings;
    }

    public CheckingAccount getChecking() {
        return checking;
    }

    public void setChecking(CheckingAccount checking) {
        this.checking = checking;
    }
    
    
    
}
