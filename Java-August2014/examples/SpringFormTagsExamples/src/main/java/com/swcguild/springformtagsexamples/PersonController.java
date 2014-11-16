/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.springformtagsexamples;

import com.swcguild.springformtagsexamples.model.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class PersonController {

    @RequestMapping(value = "/displayNewPersonForm", method = RequestMethod.GET)
    public String displayNewPersonForm(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);

        // create list of departments - used for rendering a select box
        List<String> deptList = new ArrayList<>();
        deptList.add("Accounting");
        deptList.add("HR");
        deptList.add("Engineering");
        deptList.add("Marketing");
        model.addAttribute("depts", deptList);

        // create hobbies list
        List<String> hobbyList = new ArrayList<>();
        hobbyList.add("Gardening");
        hobbyList.add("Painting");
        hobbyList.add("Running");
        hobbyList.add("Music");

        model.addAttribute("hobbyList", hobbyList);

        return "newPersonForm";
    }

    @RequestMapping(value = "/createNewPerson", method = RequestMethod.POST)
    public String createNewPerson(@ModelAttribute("person") Person person, Model model) {

        model.addAttribute("person", person);

        return "displayPerson";
    }

    @RequestMapping(value="/displayEditPersonForm", method=RequestMethod.GET)
    public String displayEditPersonForm(Model model) {
        Person p = new Person();
        p.setFirstName("James");
        p.setLastName("Johnson");
        p.setGender("M");
        p.setDepartment("Engineering");
        p.setDateOfBirth(LocalDate.of(1980, 02, 05));
        p.setHobbies(new String[]{"Gardening", "Running"});
        p.setActive(false);
        
        model.addAttribute("person", p);

        // create list of departments - used for rendering a select box
        List<String> deptList = new ArrayList<>();
        deptList.add("Accounting");
        deptList.add("HR");
        deptList.add("Engineering");
        deptList.add("Marketing");
        model.addAttribute("depts", deptList);

        // create hobbies list
        List<String> hobbyList = new ArrayList<>();
        hobbyList.add("Gardening");
        hobbyList.add("Painting");
        hobbyList.add("Running");
        hobbyList.add("Music");

        model.addAttribute("hobbyList", hobbyList);

        return "editPersonForm";
    }
    
    @RequestMapping(value="/editPerson", method=RequestMethod.POST)
    public String editPerson(@ModelAttribute("person") Person person, Model model) {
        model.addAttribute("person", person);
        return "displayPerson";
    }

}
