/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitconverterweb;

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
@WebServlet(name = "UnitConverterServlet", urlPatterns = {"/UnitConverterServlet"})
public class UnitConverterServlet extends HttpServlet {

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
        String operation = request.getParameter("operation");

        switch (operation) {
            case "temperature":
                convertTemp(request, response);
                break;
            case "mass":
                convertMass(request, response);
                break;
            case "volume":
                convertVolume(request, response);
                break;
        }
    }

    protected void convertTemp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quantityStr = request.getParameter("quantityStr1");
        String fromTemp = request.getParameter("fromTemp");
        String toTemp = request.getParameter("toTemp");

        RequestDispatcher rd;

        double quantity = 0;
        double answer = 0;

        boolean inputValid = true;
        try {
            quantity = Double.parseDouble(quantityStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage1", "Please enter a number.");
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            inputValid = false;
        }
//Celsius to Fahrenheit:   (°C × 9/5) + 32 = °F
//Fahrenheit to Celsius:   (°F − 32) x 5/9 = °C 
//Celsius to Fahrenheit:   °C × 1.8 + 32 = °F
//Fahrenheit to Celsius:   (°F − 32) / 1.8 = °C
//        Celsius to Kelvin 	K = ° C + 273
//Fahrenheit to Kelvin 	K = 5/9 (° F - 32) + 273     
//Kelvin to Fahrenheit 	° F = 9/5(° K - 273) + 32        
        if (inputValid) {
            if (fromTemp.equalsIgnoreCase("Celsius")) {
                if (toTemp.equalsIgnoreCase("Celsius")) {
                    answer = quantity;
                } else if (toTemp.equalsIgnoreCase("Farenheit")) {
                    answer = (quantity * 1.8) + 32;
                } else {
                    answer = quantity + 273;
                }
            } else if (fromTemp.equalsIgnoreCase("Farenheit")) {
                if (toTemp.equalsIgnoreCase("Farenheit")) {
                    answer = quantity;
                } else if (toTemp.equalsIgnoreCase("Celsius")) {
                    answer = (quantity - 32) / 1.8;
                } else {
                    answer = ((quantity - 32) / 1.8) + 273;
                }
            } else if (fromTemp.equalsIgnoreCase("Kelvin")) {
                if (toTemp.equalsIgnoreCase("Kelvin")) {
                    answer = quantity;
                } else if (toTemp.equalsIgnoreCase("Celsius")) {
                    answer = quantity - 273;
                } else {
                    answer = (quantity - 273) * 1.8 + 32;
                }
            }

            request.setAttribute("from", fromTemp);
            request.setAttribute("to", toTemp);
            request.setAttribute("quantity", quantity);
            request.setAttribute("answer", answer);            
            rd = request.getRequestDispatcher("unitconverter.jsp");
            rd.forward(request, response);
        }

    }

    protected void convertMass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quantityStr = request.getParameter("quantityStr2");
        String fromMass = request.getParameter("fromMass");
        String toMass = request.getParameter("toMass");

        RequestDispatcher rd;

        double quantity = 0;
        double answer = 0;

        boolean inputValid = true;
        try {
            quantity = Double.parseDouble(quantityStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage2", "Please enter a number.");
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            inputValid = false;
        }

        if (inputValid) {
            if (fromMass.equalsIgnoreCase("Kilogram")) {
                if (toMass.equalsIgnoreCase("Kilogram")) {
                    answer = quantity;
                } else if (toMass.equalsIgnoreCase("Ounce")) {
                    answer = quantity * 35.274;
                } else {
                    //Pound
//                2.2046226218
                    answer = quantity * 2.2046;
                }
            } else if (fromMass.equalsIgnoreCase("Ounce")) {
                if (toMass.equalsIgnoreCase("Ounce")) {
                    answer = quantity;
                } else if (toMass.equalsIgnoreCase("Kilogram")) {
                    answer = quantity / 35.274;
                } else {
                    //pound
                    answer = quantity / 2.2046;
                }
            } else {
                //Pound
                if (toMass.equalsIgnoreCase("Pound")) {
                    answer = quantity;
                } else if (toMass.equalsIgnoreCase("Kilogram")) {
                    answer = quantity / 2.2046;
                } else {
                    //Ounce
                    answer = quantity * 16.0;
                }
            }
        }
        request.setAttribute("from", fromMass);
        request.setAttribute("to", toMass);
        request.setAttribute("quantity", quantity);
        request.setAttribute("answer", answer);
        rd = request.getRequestDispatcher("unitconverter.jsp");
        rd.forward(request, response);
    }

    protected void convertVolume(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quantityStr = request.getParameter("quantityStr3");
        String fromVolume = request.getParameter("fromVolume");
        String toVolume = request.getParameter("toVolume");

        RequestDispatcher rd;

        double quantity = 0;
        double answer = 0;

        boolean inputValid = true;
        try {
            quantity = Double.parseDouble(quantityStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage3", "Please enter a number.");
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            inputValid = false;
        }

        if (inputValid) {
            if (fromVolume.equalsIgnoreCase("Galon")) {
                if (toVolume.equalsIgnoreCase("Galon")) {
                    answer = quantity;
                } else if (toVolume.equalsIgnoreCase("Quart")) {
                    answer = quantity * 4;
                } else {
                    //Pint
                    answer = quantity * 8;
                }
            } else if (fromVolume.equalsIgnoreCase("Quart")) {
                if (toVolume.equalsIgnoreCase("Quart")) {
                    answer = quantity;
                } else if (toVolume.equalsIgnoreCase("Galon")) {
                    answer = quantity / 4;
                } else {
                    //Pint
                    answer = quantity * 2;
                }
            } else {
                //Pint
                if (toVolume.equalsIgnoreCase("Pint")) {
                    answer = quantity;
                } else if (toVolume.equalsIgnoreCase("Galon")) {
                    answer = quantity / 8;
                } else {
                    //Quart
                    answer = quantity / 2;
                }
            }
        }
        request.setAttribute("from", fromVolume);
        request.setAttribute("to", toVolume);
        request.setAttribute("quantity", quantity);
        request.setAttribute("answer", answer);
        rd = request.getRequestDispatcher("unitconverter.jsp");
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
