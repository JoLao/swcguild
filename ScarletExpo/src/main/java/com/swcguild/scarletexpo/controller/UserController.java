/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.controller;

import com.swcguild.scarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.scarletexpo.model.Note;
import com.swcguild.scarletexpo.model.User;
import com.swcguild.scarletexpo.model.view.UserView;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jlao
 */
@Controller
public class UserController {

    private ScarletExpoDao scarletExpoDao;

    @Inject
    public void setScarletExpoDao(ScarletExpoDao scarletExpoDao) {
        this.scarletExpoDao = scarletExpoDao;
    }

    @RequestMapping(value = "/addUserForm", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "Portal/addUserForm";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Portal/addUserForm";
        }
        try {
            if (scarletExpoDao.getUserByUserName(user.getUserName()) == null) {                
                scarletExpoDao.addNewUser(user);                
                return "redirect:addUserForm?message=Successfully added.";
            } else {
                model.addAttribute("message", "User name already exists.");
                return "Portal/addUserForm";
            }

        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "Portal/addUserForm";
        }
    }

    @RequestMapping(value = "/editUserForm", method = RequestMethod.GET)
    public String editUserForm(@RequestParam("userId") int userId, Model model) {
        User user = scarletExpoDao.getUserByUserId(userId);
     
        model.addAttribute("user", user);
        return "Portal/editUserForm";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Portal/editUserForm";
        }
        try {
            scarletExpoDao.updateUser(user);
            scarletExpoDao.updaterUserProfile(user);            
            return "redirect:displayUserList?message=Successfully updated.";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "Portal/editUserForm";
        }
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("userId") int userId, Model model) {
        User user = scarletExpoDao.getUserByUserId(userId);
        user.setIsActive(false);
        scarletExpoDao.updateUser(user);        

        return "redirect:displayUserList?message=Successfully deactivated.";
    }

    @RequestMapping(value = "/displayUserList", method = RequestMethod.GET)
    public String displayUserList(Model model) {
        List<UserView> userList = scarletExpoDao.displayAllUsers();

        model.addAttribute("userViewList", userList);
        return "Portal/displayUserList";
    }

    @RequestMapping(value = "/displayUserNotesById", method = RequestMethod.GET)
    public String userNotesById(@RequestParam("userId") int userId, Model model) {
        List<Note> userNotes = scarletExpoDao.getNotesByUserId(userId);
        return "Portal/displayUserNotesById";
    }

}
