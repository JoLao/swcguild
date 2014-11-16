/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labs;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalculator {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Annual Interest Rate");
        
        float annualRate = 10;
        double principal = 500;
        int numYears = 20;        
        
        System.out.print("Annual Rate : ");
        annualRate = sc.nextFloat();
        
        System.out.print("Principal : ");
        principal = sc.nextDouble();
        
        System.out.print("# of Years : ");
        numYears = sc.nextInt();
        
        double begPrincipal = 0;
        double endPrincipal = principal;
        double interest = 0;
        
        System.out.println("Year #       Beginning Principal        Interest    Ending Principal ");        
        NumberFormat numberFormat = new DecimalFormat("$#,###.00");
        NumberFormat yrFormat = new DecimalFormat("##");
        
        for (int i = 1; i <= numYears; i++) {
           begPrincipal = endPrincipal;
            for (int j = 1; j < 5; j++)   {
                endPrincipal = endPrincipal * (1 + annualRate/4/100);   //502.5
                
            }
            interest = endPrincipal - begPrincipal; 
            System.out.println(String.format("%3s",yrFormat.format(i))+"              "+
                    String.format("%15s",numberFormat.format(begPrincipal))+" "+
                    String.format("%15s",numberFormat.format(interest))+"     "+
                    String.format("%15s",numberFormat.format(endPrincipal)));
        }
    }
    
}
