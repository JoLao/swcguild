/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankaccountmanager;

public class CheckingAccount extends Account {
    private double       overDraftAmt;
    private final double OVERDRAFT_AMT = 10.00;
    
    @Override
    public int withdraw(double money) {
        int result = 0;
    
        //result
        //0      -> successful withdrawal        
        //-1     -> withdraw not allowed
        //-2     -> insufficient funds applying overdraft
        if (money > this.availableBalance) {
            if ((money - this.availableBalance) <= 100 && this.availableBalance > 0) {
                overDraftAmt += OVERDRAFT_AMT;
                balance -= money;
                availableBalance -= money;
                result = -2;
            } else {
                result = -1;
            }
        } else {
            balance -= money;
            availableBalance -= money;
            result = 0;
        }
        return result;        
    }    
}
