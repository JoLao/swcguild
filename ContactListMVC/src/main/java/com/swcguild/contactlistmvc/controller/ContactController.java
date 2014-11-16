package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    private ContactListDao dao;

    @Inject
    public ContactController(ContactListDao dao) {
        this.dao = dao;
    }

    //returns the logical view
    //input parameters are objects used to give data to the view
    @RequestMapping(value = "/contactList", method = RequestMethod.GET)
    public String displayContactList(Model model) {
        List<Contact> cList = dao.getAllContacts();
        model.addAttribute("contactList", cList);
        return "displayContactList";
    }

    @RequestMapping(value = "/displayNewContactForm", method = RequestMethod.GET)
    public String displayNewContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "addContactForm";
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
//    public String addContact(Model model, HttpServletRequest request, HttpServletResponse response) {
//    public String addContact(@ModelAttribute("contact") Contact contact, Model model) {
      public String addContact(@Valid Contact contact, BindingResult result, Model model) {

//        String firstName = request.getParameter("contactFirstName");
//        String lastName = request.getParameter("contactLastName");
//        String company = request.getParameter("contactCompany");
//        String phone = request.getParameter("contactPhone");
//        String email = request.getParameter("contactEmail");
//
//        Contact newContact = new Contact();
//        newContact.setFirstName(firstName);
//        newContact.setLastName(lastName);
//        newContact.setCompany(company);
//        newContact.setPhone(phone);
//        newContact.setEmail(email);
//        dao.addContact(newContact);

        try {
            if (result.hasErrors()) {
                return "addContactForm";
            }
            dao.addContact(contact);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "addContactForm";
        }
        return "redirect:contactList";
//        return "contactList";  //--> this one doesn't work. status 404 and the path given was /jsp/contactList.jsp
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public String deleteContact(@RequestParam("contactId") int id) {
        dao.removeContact(id);

        return "redirect:contactList";
    }

    @RequestMapping(value = "/displayEditContactForm", method = RequestMethod.GET)
    public String displayEditContactForm(@RequestParam("contactId") int id, Model model) {
        Contact c = dao.getContactById(id);
        model.addAttribute("contact", c);

        return "editContactForm";
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.POST)
    public String updateContact(@Valid Contact contact, BindingResult result, Model model) {
//    public String updateContact(HttpServletRequest request, HttpServletResponse response) {
//    public String updateContact(@ModelAttribute("contact") Contact contact, Model model) {
//        Contact c = new Contact();
//        c.setContactId(Integer.parseInt(request.getParameter("contactId")));
//        c.setFirstName(request.getParameter("contactFirstName"));
//        c.setLastName(request.getParameter("contactLastName"));
//        c.setCompany(request.getParameter("contactCompany"));
//        c.setPhone(request.getParameter("contactPhone"));
//        c.setEmail(request.getParameter("contactEmail"));

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
