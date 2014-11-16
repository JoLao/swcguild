package com.swcguild.addressbook2mvcspring.controller;

import com.swcguild.addressbook2mvcspring.dao.AddressBookDao;
import com.swcguild.addressbook2mvcspring.model.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    private AddressBookDao dao;

    @Autowired
    public AddressBookController(AddressBookDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/addAddressForm", method = RequestMethod.GET)
    public String addAddressForm() {
        return "addAddressForm";

    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String addAddress(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        boolean inputValid = true;
        if (firstName.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage1", "First Name cannot be blank.");
        }

        if (lastName.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage2", "Last Name cannot be blank.");
        }

        if (street.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage3", "Street cannot be blank.");
        }

        if (city.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage4", "City cannot be blank.");
        }

        if (state.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage5", "State cannot be blank.");
        }

        if (zip.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage6", "Zip Code cannot be blank.");
        }

        if (inputValid) {
            Address a = new Address(lastName, firstName, street, city, state, zip);
            dao.addAddress(a);
            request.setAttribute("message", "Address successfully added.");
        }
        if (inputValid) {
            return "redirect:addAddressForm?message=true";
        } else {
            return "addAddressForm";
        }
    }

    @RequestMapping(value = "/searchAddress", method = RequestMethod.GET)
    public String searchAddress(Model model, HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        String searchStr = request.getParameter("searchStr");
        List<Address> aList = new ArrayList<>();
        Map<String, List<Address>> byStateMap = new HashMap<>();
        int addressId = -1;
        Address address;

        request.setAttribute("errorMessage", " ");
        if (search == null) {
            aList = dao.listAllAddressesList();
            model.addAttribute("inputInd", "list");
            model.addAttribute("aList", aList);
        } else if (search.equals("addressId")) {
            try {
                addressId = Integer.parseInt(searchStr);
                address = dao.getAddressById(addressId);
                if (address != null) {
                    aList.add(dao.getAddressById(addressId));
                    model.addAttribute("inputInd", "list");
                    model.addAttribute("aList", aList);
                } else {
                    request.setAttribute("errorMessage", "Address not found.");
                }
            } catch (NumberFormatException nfe) {
                request.setAttribute("errorMessage", "Please enter an integer.");
            }

        } else if (search.equals("lastName")) {
            aList = dao.listAddressesByLastName(searchStr);
            model.addAttribute("inputInd", "list");
            model.addAttribute("aList", aList);
        } else if (search.equals("city")) {
            aList = dao.listAddressesByCity(searchStr);
            model.addAttribute("inputInd", "list");
            model.addAttribute("aList", aList);
        } else if (search.equals("state")) {
            byStateMap = dao.listAddressesByState(searchStr);
            model.addAttribute("inputInd", "map");
            model.addAttribute("byStateMap", byStateMap);
            return "displayAddressesMap";
        } else if (search.equals("zip")) {
            aList = dao.listAddressesByZip(searchStr);
            model.addAttribute("inputInd", "list");
            model.addAttribute("aList", aList);
        } else {
            aList = dao.listAllAddressesList();
            model.addAttribute("inputInd", "list");
            model.addAttribute("aList", aList);
        }

        return "displayAddresses";
    }

    @RequestMapping(value = "/editAddressForm", method = RequestMethod.GET)
    public String editAddressForm(@RequestParam("addressId") int addressId, Model model) {
        Address a = dao.getAddressById(addressId);
        model.addAttribute("address", a);
        return "editAddressForm";
    }

    @RequestMapping(value = "/editAddress", method = RequestMethod.POST)
    public String editAddress(HttpServletRequest request, HttpServletResponse response, Model model) {
        String search = request.getParameter("search");
        String searchStr = request.getParameter("searchStr");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        int addressId = Integer.parseInt(request.getParameter("addressId"));

        boolean inputValid = true;
        if (firstName.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage1", "First Name cannot be blank.");
        }

        if (lastName.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage2", "Last Name cannot be blank.");
        }

        if (street.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage3", "Street cannot be blank.");
        }

        if (city.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage4", "City cannot be blank.");
        }

        if (state.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage5", "State cannot be blank.");
        }

        if (zip.equalsIgnoreCase("")) {
            inputValid = false;
            request.setAttribute("errorMessage6", "Zip Code cannot be blank.");
        }
        Address a = new Address(lastName, firstName, street, city, state, zip);
        a.setAddressId(addressId);
        if (inputValid) {
            dao.editAddress(a);
            return "redirect:searchAddress";
        } else {
            model.addAttribute("address", a);
//            return "editAddressForm?addressId=" + addressId;    --> got status 404
            return "editAddressForm";   //works but it erases all my data. need to pass back address object
        }

    }

    @RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
    public String deleteAddressForm(@RequestParam("addressId") int addressId) {
        dao.removeAddress(addressId);
        return "redirect:searchAddress";
    }
}
