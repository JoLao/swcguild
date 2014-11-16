package com.swcguild.sitemapmvcspring.controller;

import com.swcguild.sitemapmvcspring.model.InterestPeriod;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SiteMapController {

    @RequestMapping (value = "/luckyseven", method = RequestMethod.GET)
    public String luckySeven() {
        return "luckyseven";
    }
    
    @RequestMapping (value="/lsresponse", method = RequestMethod.POST)
    public String luckySevenResponse(HttpServletRequest request, HttpServletResponse response) {
        String moneyStr = request.getParameter("moneyStr");
        double money = 0;
        RequestDispatcher rd;
        try {
            money = Double.parseDouble(moneyStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage", "Please enter a valid positive dollar amount.");            
            return "luckyseven";
        }
        
        Random rGen1, rGen2;
        int dice1, dice2, sum;
        int totalRolls = 0; 
        double rollsMostMoney, mostMoney;
        mostMoney = money;
        rollsMostMoney = 1;
        
        while (money > 0) {
            rGen1 = new Random();
            rGen2 = new Random();
        
            dice1 = rGen1.nextInt(6) + 1;
            dice2 = rGen2.nextInt(6) + 1;
            
            sum = dice1 + dice2;
            
         
            if (sum == 7) {
                money += 4;
            } else {
                money -= 1;
            }   
            totalRolls++;
            
            if (money > mostMoney) {
                mostMoney = money;
                rollsMostMoney = totalRolls;
            }
            
        } //end while money > 0
        
        request.setAttribute("totalRolls", Double.toString(totalRolls));
        request.setAttribute("rollsMostMoney", Double.toString(rollsMostMoney));
        request.setAttribute("mostMoney", Double.toString(mostMoney));
        return "lsresponse";
    }
    
    @RequestMapping (value = "/factorizer", method = RequestMethod.GET)
    public String factorizer() {
        return "factorizer";
    }
    
    @RequestMapping (value="/factresponse", method = RequestMethod.POST)
    public String factorizerResponse(HttpServletRequest request, HttpServletResponse response) {
        String numStr = request.getParameter("numStr");
        int num = 0;        
        int addNum = 0;
        List<Integer> numList = new ArrayList<>();
        boolean perfectNum = false;
        boolean primeNum   = true;
        try {
            num = Integer.parseInt(numStr);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errorMessage", "Please enter an integer.");
            return "factorizer";            
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
        return "factresponse";
    }
    
    @RequestMapping (value = "/interestcalc", method = RequestMethod.GET)
    public String interestCalculator() {
        return "interestcalc";
    }
    
    @RequestMapping (value="/icresponse", method = RequestMethod.POST)
    public String interestCalculatorResponse(HttpServletRequest request, HttpServletResponse response) {
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
            
            NumberFormat numberFormat = new DecimalFormat("$#,###.00");
            NumberFormat yrFormat = new DecimalFormat("##");

            for (int i = 1; i <= numYears; i++) {
                begPrincipal = endPrincipal;
                for (int j = 1; j < 5; j++) {
                    endPrincipal = endPrincipal * (1 + annualRate / 4 / 100);   //502.5

                }
                interest = endPrincipal - begPrincipal;
                
                p = new InterestPeriod();
                p.setYear(i);
                p.setBegPrincipal(begPrincipal);
                p.setInterest(interest);
                p.setEndPrincipal(endPrincipal);
                interestTable.add(p);
            }
            request.setAttribute("interestTable", interestTable);
            return "icresponse";
            
        } else {
            return "interestcalc";            
        }
    }
    
    @RequestMapping (value = "/flooringcalc", method = RequestMethod.GET)
    public String flooringCalculator() {
        return "flooringcalc";
    }
    
    @RequestMapping (value="/fcresponse", method = RequestMethod.POST)
    public String flooringCalculatorResponse(HttpServletRequest request, HttpServletResponse response) {
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
            return "fcresponse";            
        } else {
            return "flooringcalc";            
        }
    }
    
    @RequestMapping (value = "/tipcalc", method = RequestMethod.GET)
    public String tipCalculator() {
        return "tipcalc";
    }
    
    @RequestMapping (value="/tcresponse", method = RequestMethod.POST)
    public String tipCalculatorResponse(HttpServletRequest request, HttpServletResponse response) {
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
            return "tcresponse";          
        } else {
            return "tipcalc";            
        }
    }
    
    @RequestMapping (value = "/converter", method = RequestMethod.GET)
    public String unitConverter() {
        return "converter";
    }
    
    @RequestMapping (value="/csresponse", method = RequestMethod.POST)
    public String unitConverterResponse(HttpServletRequest request, HttpServletResponse response) {
        String operation = request.getParameter("operation");

        switch (operation) {
            case "temperature":
                return convertTemp(request, response);
   
            case "mass":
                return convertMass(request, response);

            case "volume":
                return convertVolume(request, response);

        }
        return "converter";
    }

    protected String convertTemp(HttpServletRequest request, HttpServletResponse response) {
        String quantityStr = request.getParameter("quantityStr1");
        String fromTemp = request.getParameter("fromTemp");
        String toTemp = request.getParameter("toTemp");

        double quantity = 0;
        double answer = 0;

        boolean inputValid = true;
        try {
            quantity = Double.parseDouble(quantityStr);
        } catch (NumberFormatException nfe) {
            inputValid = false;
            request.setAttribute("errorMessage1", "Please enter a number.");                              
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
            return "csresponse";            
        } else {
            return "converter";     
        }
    }

    protected String convertMass(HttpServletRequest request, HttpServletResponse response) {
        String quantityStr = request.getParameter("quantityStr2");
        String fromMass = request.getParameter("fromMass");
        String toMass = request.getParameter("toMass");

        double quantity = 0;
        double answer = 0;

        boolean inputValid = true;
        try {
            quantity = Double.parseDouble(quantityStr);
        } catch (NumberFormatException nfe) {
            inputValid = false;
            request.setAttribute("errorMessage2", "Please enter a number.");
             return "converter";                                
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
        return "csresponse";
    }

    protected String convertVolume(HttpServletRequest request, HttpServletResponse response) {
        String quantityStr = request.getParameter("quantityStr3");
        String fromVolume = request.getParameter("fromVolume");
        String toVolume = request.getParameter("toVolume");

        double quantity = 0;
        double answer = 0;

        boolean inputValid = true;
        try {
            quantity = Double.parseDouble(quantityStr);
        } catch (NumberFormatException nfe) {
            inputValid = false;
            request.setAttribute("errorMessage3", "Please enter a number.");
            return "converter";           
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
        return "csresponse";        
    }
}
