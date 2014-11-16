
package logic;

//Return the sum of two 6-sided dice rolls, each in the range 1..6. 
//However, if noDoubles is true, if the two dice show the same value, 
//increment one die to the next value, wrapping around to 1 if its value was 6. 
//
//RollDice(2, 3, true) → 5
//RollDice(3, 3, true) → 7
//RollDice(3, 3, false) → 6

public class RollDice {
  public int rollDice(int dice1, int dice2, boolean noDoubles) {
      int result = 0;
      
      if (dice1 >= 1 && dice1 <= 6 && dice2 >= 1 && dice2 <= 6 ) {
          if (noDoubles) {
              if (dice1 == dice2) {
                  dice2 = (dice2 % 6) + 1;
              }
          }

       }
      
      return dice1 + dice2;
  }
}
