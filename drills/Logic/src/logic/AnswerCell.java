
package logic;

//Your cell phone rings. Return true if you should answer it. Normally you answer, 
//except in the morning you only answer if it is your mom calling. In all cases, 
//if you are asleep, you do not answer. 
//
//AnswerCell(false, false, false) → true
//AnswerCell(false, false, true) → false
//AnswerCell(true, false, false) → false
public class AnswerCell {
    public boolean answerCell(boolean shouldAnswer, boolean isMorning, boolean momCalling, boolean isAsleep) {
        boolean result = true;
        if (isAsleep) {
            result = false;
        } else if (shouldAnswer) {
            result = true;
        } else if (isMorning) {
            if (momCalling) {
                result = true;
            } else {
                result = false;
            } 
        } else {
            result = true;
        }
        return result;
    }
}
