package com.swcguild.myscarletexpo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    
    @RequestMapping ({"/","home","index",})
    public String displayIndex() {
        return "index";
    }
    
    @RequestMapping ({"Equipment-Services"})
    public String displayEquipmentServices() {
        return "Equipment-Services";
    }
    
    @RequestMapping ({"Rental-Policy"})
    public String displayRentalPolicy() {
        return "Rental-Policy";
    }
    @RequestMapping ({"About-Us"})
    public String displayAboutUs() {
        return "About-Us";
    }    
    
    @RequestMapping ({"AdminPortalHome", "login"})
    public String displayAdminPortal() {
        return "Portal/AdminPortalHome";
    }
    
    @RequestMapping ({"Equipment"})
    public String displayEquipment() {
        return "Portal/Equipment";
    }    
    
    @RequestMapping ({"Equipment-Categories"})
    public String displayEquipmentCategories() {
        return "Portal/Equipment-Categories";
    }    
    
    @RequestMapping ({"Events"})
    public String displayEvents() {
        return "Portal/Events";
    }  
    @RequestMapping ({"Users"})
    public String displayUsers() {
        return "Portal/Users";
    }  
    @RequestMapping ({"Check-In-Out"})
    public String displayCheckInOut() {
        return "Portal/Check-In-Out";
    } 
    
    @RequestMapping ({"Reports"})
    public String displayReports() {
        return "Portal/Reports";
    } 
    
    @RequestMapping ({"checkIn"})
    public String displayCheckInPage() {
        return "Portal/checkIn";
    }
    
    @RequestMapping ({"displayCheckedOutEquipment"})
    public String displayCheckedOutEquipment() {
        return "Portal/displayCheckedOutEquipment";
    } 
    
    @RequestMapping ({"reportA"})
    public String displayReportA() {
        return "Portal/ReportFolder/reportA";
    } 
    
    @RequestMapping ({"reportB"})
    public String displayReportB() {
        return "Portal/ReportFolder/reportB";
    } 
    
    @RequestMapping ({"reportC"})
    public String displayReportC() {
        return "Portal/ReportFolder/reportC";
    } 
    
    @RequestMapping ({"reportD"})
    public String displayReportD() {
        return "Portal/ReportFolder/reportD";
    } 
    @RequestMapping ({"reportE"})
    public String displayReportE() {
        return "Portal/ReportFolder/reportE";
    } 
    
    @RequestMapping ({"reportF"})
    public String displayReportF() {
        return "Portal/ReportFolder/reportF";
    }
    
    @RequestMapping ({"addEventForm"})
    public String displayAddEventForm() {
        return "Portal/addEventForm";
    }


    } 
    
    

