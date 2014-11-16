/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package refactorintoobjects;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LuckySevens {
    public void execute() {
     
        Scanner sc = new Scanner(System.in);
        
        int money = 0;       
        
        System.out.print("How many dollars do you have? ");
        money = sc.nextInt();
        
        Random rGen1, rGen2;
        int dice1, dice2, sum;
        int totalRolls = 0, rollsMostMoney, mostMoney;
        mostMoney = money;
        rollsMostMoney = 1;
        
        while (money > 0) {
            rGen1 = new Random();
            rGen2 = new Random();
        
            dice1 = rGen1.nextInt(6) + 1;
            dice2 = rGen2.nextInt(6) + 1;
            
            sum = dice1 + dice2;
            
         
            if (sum == 7) {
                money += 4;
            } else {
                money -= 1;
            }   
            totalRolls++;
            
            if (money > mostMoney) {
                mostMoney = money;
                rollsMostMoney = totalRolls;
            }
            
        } //end while money > 0
        
        System.out.println("You are broke after "+totalRolls+" rolls");
        System.out.println("You should have quit after "+rollsMostMoney+" rolls when you had $"+mostMoney);
    }
    
}
