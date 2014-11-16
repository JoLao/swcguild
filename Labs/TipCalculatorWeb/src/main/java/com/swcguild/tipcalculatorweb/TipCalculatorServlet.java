/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.tipcalculatorweb;

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
@WebServlet(name = "TipCalculatorServlet", urlPatterns = {"/TipCalculatorServlet"})
public class TipCalculatorServlet extends HttpServlet {

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
        
        String dollarValueStr = request.getParameter("dollarValueStr");
        String tipPercentageStr = request.getParameter("tipPercentageStr");
        
        double dollarValue = 0;
        double tipPercentage = 0;
        double tip;
        
        RequestDispatcher rd;
        boolean validInput = true;
        try {
            dollarValue = Double.parseDouble(dollarValueStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage1", "Please enter dollar amount");
            validInput = false;
        }
        
        try {
            tipPercentage = Double.parseDouble(tipPercentageStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage2", "Please enter value in percentage.");
            validInput = false;
        }

        if (validInput) {
            tip = dollarValue * tipPercentage / 100;
            request.setAttribute("dollarValue", dollarValue);
            request.setAttribute("tipPercentage", tipPercentage);
            request.setAttribute("tip", tip);
            request.setAttribute("total", (dollarValue + tip));
            rd = request.getRequestDispatcher("tipcalculator.jsp");
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
