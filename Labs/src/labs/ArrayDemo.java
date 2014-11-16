/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labs;

/**
 *
 * @author apprentice
 */
public class ArrayDemo {
    
    public static void main(String[] args) {
        //int[] teamScores = new int[10];
        
        //teamScores[0] = 34;
        int[] teamScores = {2, 34, 100, 80, 24};
        
        for (int i = 0; i < teamScores.length; i++) {
            System.out.println("Element = " + teamScores[i]);
        }
        
        for (int num : teamScores) {
            System.out.println("Element = " +num);
        }
        
        String[][] cityTeamNames = {
            {"Cleveland", "Browns", "Cavs", "Indians"},
            {"Columbus", "Bluejackets", "Buckeyes"},
            {"Pittsburgh", "Steelers", "Pirates", "Penguins"}
        };
        
        for (int i = 0; i < cityTeamNames.length; i++) {
            for (int j = 0; j < cityTeamNames[i].length; j++) {
                System.out.print(cityTeamNames[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
