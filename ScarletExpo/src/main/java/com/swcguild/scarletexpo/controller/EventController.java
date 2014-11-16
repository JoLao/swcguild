/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.controller;

import com.swcguild.scarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.scarletexpo.model.Event;
import com.swcguild.scarletexpo.model.ProductItem;
import com.swcguild.scarletexpo.model.User;
import com.swcguild.scarletexpo.model.view.EventView;
import com.swcguild.scarletexpo.model.view.ProductCheckOutView;
import com.swcguild.scarletexpo.model.view.ProductView;
import com.swcguild.scarletexpo.model.view.UserView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

/**
 *
 * @author jlao
 */
@Controller
public class EventController {

    private ScarletExpoDao scarletExpoDao;

    @Inject
    public void setScarletExpoDao(ScarletExpoDao scarletExpoDao) {
        this.scarletExpoDao = scarletExpoDao;
    }

    @RequestMapping(value = "/checkOut", method = RequestMethod.GET)
    public String checkOutForm(Model model) {
        List<ProductView> productViewList = scarletExpoDao.displayAvailableProducts();
        ProductCheckOutView productCheckOutView = new ProductCheckOutView();
        productCheckOutView.setProductCheckOutList(productViewList);

        List<UserView> userList = scarletExpoDao.displayAllUsers();
        model.addAttribute("users", userList);

        Event e = new Event();
        model.addAttribute("newEvent", e);
        model.addAttribute("productCheckOutView", productCheckOutView);

        return "Portal/checkOut";
    }

    @RequestMapping(value = "/processExpressCheckOut", method = RequestMethod.POST)
    public String processExpressCheckOut(@ModelAttribute("newEvent") Event event,
                        @RequestParam("userId") int userId,
            Model model) {

        //create event, event_product_items, update product_items
        User user = scarletExpoDao.getUserByUserId(userId);
        if (user == null) {
            List<ProductView> productViewList = scarletExpoDao.displayAvailableProducts();
            ProductCheckOutView productCheckOutView = new ProductCheckOutView();
            productCheckOutView.setProductCheckOutList(productViewList);
            model.addAttribute("newEvent", event);
            model.addAttribute("productCheckOutView", productCheckOutView);
            List<UserView> userList = scarletExpoDao.displayAllUsers();
            model.addAttribute("users", userList);
            model.addAttribute("userMessage", "User name not found.");
            return "Portal/checkOut";
        }
        if (!user.isIsActive()) {
            List<ProductView> productViewList = scarletExpoDao.displayAvailableProducts();
            ProductCheckOutView productCheckOutView = new ProductCheckOutView();
            productCheckOutView.setProductCheckOutList(productViewList);
            model.addAttribute("newEvent", event);
            model.addAttribute("productCheckOutView", productCheckOutView);
            List<UserView> userList = scarletExpoDao.displayAllUsers();
            model.addAttribute("users", userList);
            model.addAttribute("userMessage", "User not active.");
            return "Portal/checkOut";
        }

        if (event.getProductItemIds().length == 0) {
            List<ProductView> productViewList = scarletExpoDao.displayAvailableProducts();
            ProductCheckOutView productCheckOutView = new ProductCheckOutView();
            productCheckOutView.setProductCheckOutList(productViewList);
            model.addAttribute("newEvent", event);
            model.addAttribute("productCheckOutView", productCheckOutView);
            List<UserView> userList = scarletExpoDao.displayAllUsers();
            model.addAttribute("users", userList);
            model.addAttribute("userMessage", "Please choose items to check out.");
            return "Portal/checkOut";
        }

        event.setEventDesc(user.getUserName() + " " + LocalDate.now());
        event.setEventStart(LocalDate.now().toString());
        event.setEventEnd(LocalDate.now().plusDays(7).toString());
        event.setReturnDate(LocalDate.now().plusDays(7).toString());
        event.setUserId(user.getUserId());

        scarletExpoDao.createEventsAndReserveProductItems(event);

        return "redirect:displayEventList?message=Sucessfully checked out.";
    }

    @RequestMapping(value = "/checkIn", method = RequestMethod.GET)
    public String checkInForm(Model model) {

        List<EventView> events = scarletExpoDao.displayAllEvents();
        model.addAttribute("events", events);

        return "Portal/checkIn";
    }

    @RequestMapping(value = "/processExpressCheckIn", method = RequestMethod.GET)
    public String processExpressCheckIn(@RequestParam("eventId") int eventId, Model model) {

        Event event = new Event();
        try {
            event = scarletExpoDao.getEventsByEventId(eventId);
            event.setReturnDate(LocalDate.now().toString());
            List<ProductItem> piList = scarletExpoDao.getProductItemByEventId(eventId);
            int[] productItemIds = new int[piList.size()];
            int i = 0;
            for (ProductItem pi : piList) {
                productItemIds[i] = pi.getProductItemId();
                i++;
            }
            event.setProductItemIds(productItemIds);
            scarletExpoDao.checkInEventsAndPrductITems(event);
            return "redirect:displayEventList?message=Sucessfully checked in.";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "Portal/displayEventList";
        }

    }

    @RequestMapping(value = "/displayEventList", method = RequestMethod.GET)
    public String displayCheckedOutEquipment(Model model) {
        List<EventView> events = scarletExpoDao.displayAllEvents();
        model.addAttribute("events", events);
        return "Portal/displayEventList";
    }

    @RequestMapping(value = "/addEventForm", method = RequestMethod.GET)
    public String addEventForm(Model model) {
        model.addAttribute("event", new Event());
        List<UserView> userList = scarletExpoDao.displayAllUsers();
        model.addAttribute("users", userList);
        return "Portal/addEventForm";
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public String addEvent(@Valid Event event, BindingResult result, @RequestParam("userId") int userId, Model model) {
        List<UserView> userList = scarletExpoDao.displayAllUsers();
        model.addAttribute("users", userList);

        if (result.hasErrors()) {
            return "Portal/addEventForm";
        }
        LocalDate testDate;
        boolean isValid = true;

        if (event.getEventStart() == null || event.getEventStart().equals("")) {
            event.setEventStart(LocalDate.now().toString());
        } else {
            try {
                testDate = LocalDate.parse(event.getEventStart(), DateTimeFormatter.ISO_DATE);
                event.setEventStart(testDate.toString());
            } catch (DateTimeParseException e) {
                model.addAttribute("startMsg", "Invalid date entered. Enter date in YYYY-MM-DD format.");
                isValid = false;
            }
        }

        if (event.getEventEnd() == null || event.getEventEnd().equals("")) {
            event.setEventEnd(LocalDate.now().plusDays(14).toString());
        } else {
            try {
                testDate = LocalDate.parse(event.getEventEnd(), DateTimeFormatter.ISO_DATE);
                event.setEventEnd(testDate.toString());
            } catch (DateTimeParseException e) {
                model.addAttribute("endMsg", "Invalid date entered. Enter date in YYYY-MM-DD format.");
                isValid = false;
            }
        }

        if (event.getReturnDate() == null || event.getReturnDate().equals("")) {
            event.setReturnDate(LocalDate.now().plusDays(14).toString());
        } else {
            try {
                testDate = LocalDate.parse(event.getReturnDate(), DateTimeFormatter.ISO_DATE);
                event.setReturnDate(testDate.toString());
            } catch (DateTimeParseException e) {
                model.addAttribute("returnMsg", "Invalid date entered.  Enter date in YYYY-MM-DD format.");
                isValid = false;
            }
        }

        User user = scarletExpoDao.getUserByUserId(userId);
        if (user == null) {
            model.addAttribute("userMessage", "User name not found.");
            isValid = false;
        }
        if (!user.isIsActive()) {
            model.addAttribute("userMessage", "User not active.");
            isValid = false;
        }

        if (isValid) {
            try {
                scarletExpoDao.createEvent(event);
                return "redirect:addEventForm?message=Successfully added.";
            } catch (Exception e) {
                model.addAttribute("message", e.getMessage());
                return "Portal/addEventForm";
            }
        } else {
            return "Portal/addEventForm";
        }

    }

    @RequestMapping(value = "/editEventForm", method = RequestMethod.GET)
    public String editEventForm(@RequestParam("eventId") int eventId, Model model) {
        Event event = new Event();
        try {
            event = scarletExpoDao.getEventsByEventId(eventId);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("event", event);
        return "Portal/editEventForm";
    }

    @RequestMapping(value = "/editEvent", method = RequestMethod.POST)
    public String editEvent(@ModelAttribute("event") Event event,
            //            @RequestParam("username") String username,
            Model model) {
        LocalDate testDate;
        boolean isValid = true;

        if (event.getEventStart() != null) {
            try {
                testDate = LocalDate.parse(event.getEventStart(), DateTimeFormatter.ISO_DATE);
                event.setEventStart(testDate.toString());
            } catch (Exception e) {
                model.addAttribute("startMsg", "Invalid date entered.");
                isValid = false;
            }
        }

        if (event.getEventEnd() != null) {
            try {
                testDate = LocalDate.parse(event.getEventEnd(), DateTimeFormatter.ISO_DATE);
                event.setEventEnd(testDate.toString());
            } catch (Exception e) {
                model.addAttribute("endMsg", "Invalid date entered.");
                isValid = false;
            }
        }

//        User user = scarletExpoDao.getUserByUserName(username);
//        if (user == null) {
//            model.addAttribute("userMessage", "User name not found.");
//            isValid = false;
//        }
//        if (!user.isIsActive()) {
//            model.addAttribute("userMessage", "User not active.");
//            isValid = false;
//        }
        if (isValid) {
            try {
                scarletExpoDao.updateEvent(event);
                return "redirect:displayEventList?message=Successfully updated.";
            } catch (Exception e) {
                model.addAttribute("message", e.getMessage());
                return "Portal/editEventForm";
            }
        } else {
            return "Portal/editEventForm";
        }

    }
}
