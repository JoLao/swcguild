
package com.swcguild.baseballleague.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class BaseballLeagueRunner {
    public static void main(String[] args) {
//        BaseballLeagueController baseball = new BaseballLeagueController();
//        baseball.run();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BaseballLeagueController baseball = (BaseballLeagueController) ctx.getBean("baseballLeagueController");
        baseball.run();
    }
}
