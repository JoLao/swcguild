/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryspring.aspect;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author apprentice
 */
public class AuditAspect {

    public void writeAudit(JoinPoint jp) {
//       public void writeAudit() {
        try {
            System.out.println("AuditAspect.writeAudit()====> ");
            
            PrintWriter out = new PrintWriter(new FileWriter("audit.txt", true));
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
            String operation = jp.getSignature().getName();
                        
            out.println(timestamp+" ====> "+operation+" ");
            
            System.out.println("timestamp "+timestamp);
            out.flush();
            out.close();            
//        } catch (IOException e) {
//            System.out.println("Exception in AuditAspect.writeAudit() : " + e.getMessage());
        } catch (Throwable t) {
            System.out.println("Exception in AuditAspect.writeAudit() : " + t.getMessage());
        }
        
    }
}
