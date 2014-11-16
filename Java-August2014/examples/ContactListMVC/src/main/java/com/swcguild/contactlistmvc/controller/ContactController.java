/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author apprentice
 */
@Controller
public class ContactController {

    private ContactListDao dao;

    @Inject
    public ContactController(ContactListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/contactList", method = RequestMethod.GET)
    public String displayContactList(Model model) {
        List<Contact> cList = dao.getAllContacts();
        model.addAttribute("contactList", cList);
        return "displayContactList";
    }

    @RequestMapping(value = "/displayNewContactForm", method = RequestMethod.GET)
    public String displayNewContactForm(Model model) {
        Contact c = new Contact();
        model.addAttribute("contact", c);
        return "addContactForm";
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(Model mode,
            HttpServletRequest req,
            HttpServletResponse res) {
        String firstName = req.getParameter("contactFirstName");
        String lastName = req.getParameter("contactLastName");
        String company = req.getParameter("contactCompany");
        String phone = req.getParameter("contactPhone");
        String email = req.getParameter("contactEmail");

        Contact c = new Contact();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setCompany(company);
        c.setPhone(phone);
        c.setEmail(email);

        dao.addContact(c);

        return "redirect:contactList";
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public String deleteContact(@RequestParam("contactId") int id) {
        dao.removeContact(id);

        return "redirect:contactList";
    }

    @RequestMapping(value = "/editContactForm", method = RequestMethod.GET)
    public String displayEditContactForm(@RequestParam("contactId") int id, Model model) {
        Contact c = dao.getContactById(id);
        model.addAttribute("contact", c);

        return "editContactForm";
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.POST)
    public String updateContact(@Valid Contact contact, BindingResult result, Model model) {

        try {
            if (result.hasErrors()) {
                return "editContactForm";
            }
            dao.updateContact(contact);
            return "redirect:contactList";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "editContactForm";
        }
    }
}
