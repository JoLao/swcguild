/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian.app;

import com.swcguild.olympian.Event;
import com.swcguild.olympian.Olympian;
import com.swcguild.olympian.SpeedSkateEvent;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        
//        SkiJumper jumper = new SkiJumper();
//        System.out.println(jumper.competeInEvent());
//        
//        SkiJumper sj = (SkiJumper) ctx.getBean("superSkiJumper");
//        System.out.println(sj.competeInEvent());
        Event e = new SpeedSkateEvent();
        
        Olympian test = new Olympian(e);
        System.out.println("++++++++++++++++++++++++++++++");
        test.competeInEvent();
        System.out.println("++++++++++++++++++++++++++++++");
        
        Olympian usaSkiJumper = (Olympian) ctx.getBean("usaSkiJumper");
        System.out.println("()()()()()()(" + usaSkiJumper.getCountry() + "()()()()()(");
        usaSkiJumper.competeInEvent();
        System.out.println("=======================");
        Olympian usaSpeedSkater = (Olympian) ctx.getBean("usaSpeedSkater");
        usaSpeedSkater.competeInEvent();
        System.out.println("=======================");
        Olympian canadianSpeedSkater = (Olympian) ctx.getBean("canadianSpeedSkater");
        canadianSpeedSkater.competeInEvent();
        
        ArrayList<Event> al = new ArrayList<>();
    }
    
    
    
}
