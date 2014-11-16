/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringcalculatorweb;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "FlooringCalculatorServlet", urlPatterns = {"/FlooringCalculatorServlet"})
public class FlooringCalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String widthStr = request.getParameter("widthStr");
        String lengthStr = request.getParameter("lengthStr");
        String costStr = request.getParameter("costStr");
        
        int width = 0, length = 0;        
        int totalArea = 0, area1 = 0, area2 = 0;
        
        double cost = 0;
        double area1Cost = 0;
        double area2Cost = 0;
        double minutes = 0;
        
        double materialCost = 0;
        double laborCost = 0;        
        
        RequestDispatcher rd;
        
        boolean inputValid = true;
        
        try {
            width = Integer.parseInt(widthStr);
        } catch(NumberFormatException nfe) {
            request.setAttribute("errorMessage1", "Please enter an integer.");
            inputValid = false;
        }
            
        try {
            length = Integer.parseInt(lengthStr);
        } catch(NumberFormatException nfe) {
            request.setAttribute("errorMessage2", "Please enter an integer.");
            inputValid = false;
        }
        
        try {
            cost = Double.parseDouble(costStr);
        } catch(NumberFormatException nfe) {
            request.setAttribute("errorMessage3", "Please enter dollar amount.");
            inputValid = false;
        }
        
        if (inputValid) {
            totalArea = length * width;
            materialCost =  totalArea * cost;
            area2 = totalArea % 20;
            area1 = totalArea - area2;
            area1Cost = (area1 / 20) * 86;
            minutes = 60.0 * area2/ 20.0;
            if (minutes > 45) {
                minutes = 60;
            } else if (minutes > 30) {
                minutes = 45;
            } else if (minutes > 15) {
                minutes = 30;
            } else if (minutes > 0) {
                minutes = 15;
            } 
            area2Cost = 86.0 * minutes / 60.0;
            laborCost =  area1Cost + area2Cost;
            request.setAttribute("materialCost", materialCost);
            request.setAttribute("laborCost", laborCost);
            request.setAttribute("totalCost", (materialCost + laborCost));
            rd = request.getRequestDispatcher("flooringcalculator.jsp");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
