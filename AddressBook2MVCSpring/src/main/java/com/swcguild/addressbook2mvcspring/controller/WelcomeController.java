package com.swcguild.addressbook2mvcspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    
    @RequestMapping ({"/","welcome"})
    public String displayIndex() {
        return "welcome";
    }
}
