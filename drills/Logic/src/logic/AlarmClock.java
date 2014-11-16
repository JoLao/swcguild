
package logic;

//Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a booleanean 
//indicating if we are on vacation, return a string of the form "7:00" indicating when 
//the alarm clock should ring. Weekdays, the alarm should be "7:00" and on the weekend 
//it should be "10:00". Unless we are on vacation -- then on weekdays it should be "10:00" 
//and weekends it should be "off". 
//
//AlarmClock(1, false) → "7:00"
//AlarmClock(5, false) → "7:00"
//AlarmClock(0, false) → "10:00"
public class AlarmClock {
  
    public String ringAlarmClock(int weekday, boolean isOnVacation) {
        String clock = "";
        if (isOnVacation) {
            if (weekday >= 1 && weekday <= 5) {
                clock = "10:00";
            } else {
                clock = "off";
            }
        } else if (weekday >= 1 && weekday <= 5) {
            clock = "7:00";
        } else {
            clock = "10:00";
        }
        return clock;
    }
}
