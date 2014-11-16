/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.sitemap;

import com.swcguild.sitemap.model.InterestPeriod;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "InterestCalculatorServlet", urlPatterns = {"/InterestCalculatorServlet"})
public class InterestCalculatorServlet extends HttpServlet {

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
        String annualRateStr = request.getParameter("annualRateStr");
        String principalStr = request.getParameter("principalStr");
        String numYearsStr = request.getParameter("numYearsStr");

        float annualRate = 0;
        double principal = 00;
        int numYears = 0;
        boolean inputValid = true;
        RequestDispatcher rd;

        try {
            annualRate = Float.parseFloat(annualRateStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage1", "Please enter a value in percentage form.");
            inputValid = false;
        }

        try {
            principal = Double.parseDouble(principalStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage2", "Please enter a dollar amount.");
            inputValid = false;
        }

        try {
            numYears = Integer.parseInt(numYearsStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage3", "Please enter an integer.");
            inputValid = false;
        }

        if (inputValid) {
            List<InterestPeriod> interestTable = new ArrayList<>();
            InterestPeriod p;
            double begPrincipal = 0;
            double endPrincipal = principal;
            double interest = 0;

            System.out.println("Year #       Beginning Principal        Interest    Ending Principal ");
            NumberFormat numberFormat = new DecimalFormat("$#,###.00");
            NumberFormat yrFormat = new DecimalFormat("##");

            for (int i = 1; i <= numYears; i++) {
                begPrincipal = endPrincipal;
                for (int j = 1; j < 5; j++) {
                    endPrincipal = endPrincipal * (1 + annualRate / 4 / 100);   //502.5

                }
                interest = endPrincipal - begPrincipal;
                System.out.println(String.format("%3s", yrFormat.format(i)) + "              "
                        + String.format("%15s", numberFormat.format(begPrincipal)) + " "
                        + String.format("%15s", numberFormat.format(interest)) + "     "
                        + String.format("%15s", numberFormat.format(endPrincipal)));
                p = new InterestPeriod();
                p.setYear(i);
                p.setBegPrincipal(begPrincipal);
                p.setInterest(interest);
                p.setEndPrincipal(endPrincipal);
                interestTable.add(p);
            }
            request.setAttribute("interestTable", interestTable);
            rd = request.getRequestDispatcher("icresponse.jsp");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("interestcalc.jsp");
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
