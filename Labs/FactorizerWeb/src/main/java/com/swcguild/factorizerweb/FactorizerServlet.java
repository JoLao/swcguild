/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.factorizerweb;

import java.io.IOException;
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
@WebServlet(name = "FactorizerServlet", urlPatterns = {"/FactorizerServlet"})
public class FactorizerServlet extends HttpServlet {

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
        String numStr = request.getParameter("numStr");
        int num = 0;
        RequestDispatcher rd;
        int addNum = 0;
        List<Integer> numList = new ArrayList<>();
        boolean perfectNum = false;
        boolean primeNum   = true;
        try {
            num = Integer.parseInt(numStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage", "Please enter an integer.");
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        for (int i = 1; i < num; i++) {
            if ((num % i == 0)) {
                numList.add(i);
                addNum += i;
            }
        }
        request.setAttribute("numStr", numStr);
        request.setAttribute("numList", numList);
                
        if (addNum == num) {
            System.out.println(num+" is a perfect number.");
            perfectNum = true;
        }
        if (addNum > 1) {
            System.out.println(num+" is not a prime number.");
            primeNum = false;
        }
        request.setAttribute("perfectNum", perfectNum);
        request.setAttribute("primeNum", primeNum);
        rd = request.getRequestDispatcher("factorizer.jsp");
        rd.forward(request, response);
        
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
