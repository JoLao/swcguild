/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory.dao;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author apprentice
 */
public class SimpleTimerAspect {
    
    public Object timeMethod(ProceedingJoinPoint jp) {
        Object ret = null;
        
        try {
            long start = System.currentTimeMillis();
            
            ret = jp.proceed();
            
            long end = System.currentTimeMillis();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(jp.getSignature().getName()+ " took "+(end - start)+" ms");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } catch (Throwable t) {
            System.out.println("Exception in SimpleTimerAspect.timeMethod()");
        }
        
        return ret;
    }
}
