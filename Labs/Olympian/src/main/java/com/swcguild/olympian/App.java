/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {
        //fires up sping container
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        
//        SkiJumper jumper = new SkiJumper();
//        System.out.println(jumper.competeInEvent());
//                
//        SkiJumper sj = (SkiJumper) ctx.getBean("superSkiJumper");
//        System.out.println(sj.competeInEvent()); 

//        Event skiJumpEvent = new SkiJumpEvent();
//        Olympian o = new Olympian(skiJumpEvent);
//        System.out.println(o.competeInEvent());
        Event e = new SpeedSkateEvent();
        
        Olympian test = new Olympian(e);
        
        Olympian usaSkiJumper = (Olympian) ctx.getBean("usaSkiJumper");
        usaSkiJumper.competeInEvent();
        System.out.println("==============================");
        Olympian usaSpeedSkater = (Olympian) ctx.getBean("usaSpeedSkater");
        usaSpeedSkater.competeInEvent();
        System.out.println("==============================");
        Olympian canadianSpeedSkater = (Olympian) ctx.getBean("canadianSpeedSkater");
        canadianSpeedSkater.competeInEvent();
    }
}
