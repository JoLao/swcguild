package com.swcguild.dvdlibrarymvcspring.controller;

import com.swcguild.dvdlibrarymvcspring.dao.DvdDao;
import com.swcguild.dvdlibrarymvcspring.model.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DvdController {
    
    private DvdDao dao;
    
    @Inject
    public void setDao(DvdDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/addDvdForm", method = RequestMethod.GET)
    public String addDvdForm(Model model, HttpServletRequest request, HttpServletResponse reponse) {
        return "addDvdForm";
    }
    
    @RequestMapping(value = "/addDvd", method = RequestMethod.POST)
    public String addDvd(Model model, HttpServletRequest request, HttpServletResponse reponse) {
        String videoType = request.getParameter("videoType");
        String title = request.getParameter("title");
        String releaseDate = request.getParameter("releaseDate");
        String mpaaRating = request.getParameter("mpaaRating");
        String director = request.getParameter("director");
        String studio = request.getParameter("studio");
        String reviews = request.getParameter("reviews");
        Dvd dvd;
        LocalDate rlseDate = null;
        boolean inputValid = true;
        
        if (title.equalsIgnoreCase("")) {
            model.addAttribute("errorMessage1", "Please enter a movie title.");
            inputValid = false;
        }
        
        try {
            rlseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException dtpe) {
            model.addAttribute("errorMessage2", "Please enter a valid date.");
            inputValid = false;
        }
        
        if (director.equalsIgnoreCase("")) {
            model.addAttribute("errorMessage3", "Please enter director's name.");
            inputValid = false;
        }
        
        if (studio.equalsIgnoreCase("")) {
            model.addAttribute("errorMessage4", "Please enter studio name.");
            inputValid = false;
        }
        
        if (inputValid) {
            dvd = new Dvd();
            dvd.setVideoType(videoType);
            dvd.setTitle(title);
            dvd.setReleaseDate(rlseDate);
            dvd.setMpaaRating(mpaaRating);
            dvd.setDirector(director);
            dvd.setStudio(studio);
            dvd.setReviews(reviews);
            dao.add(dvd);
            return "redirect:addDvdForm?message=true";
        } else {
            return "addDvdForm";
        }
        
    }
    
    @RequestMapping(value = "/averageAgeForm", method = RequestMethod.GET)
    public String computeAvgDvd(Model model, HttpServletRequest request, HttpServletResponse reponse) {
        model.addAttribute("averageAge", dao.getAverageAge());
        return "averageAgeForm";
    }
    
    @RequestMapping(value = "/searchDvds", method = RequestMethod.GET)
    public String searchDvds(Model model, HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        String searchStr = request.getParameter("searchStr");
        
        List<Dvd> dvdList = new ArrayList<>();
        Map<String, List<Dvd>> byDirectorMap = new HashMap<>();
        Map<String, List<Dvd>> byDirectorMap2 = new HashMap<>();
        int dvdId = -1;
        int numYears = 0;
        Dvd dvd;
        
        request.setAttribute("message", "");
        if (search == null) {
            dvdList = dao.listAll();
            request.setAttribute("inputInd", "listAll");            
            model.addAttribute("dvdList", dvdList);
        } else if (search.equalsIgnoreCase("dvdId")) {
            try {
                dvdId = Integer.parseInt(searchStr);
                dvd = dao.getDvd(dvdId);
                if (dvd != null) {
                    dvdList.add(dvd);
                    request.setAttribute("inputInd", "dvdId");
                    model.addAttribute("dvdList", dvdList);
                } else {
                    model.addAttribute("message", "DVD not found.");
                }
            } catch (NumberFormatException nfe) {
                request.setAttribute("message", "Please enter an integer.");
            }
        } else if (search.equalsIgnoreCase("title")) {
            dvdList = dao.getByTitle(searchStr);
            request.setAttribute("inputInd", "title");
            model.addAttribute("dvdList", dvdList);
        } else if (search.equalsIgnoreCase("lastNYears")) {
            try {
                numYears = Integer.parseInt(searchStr);
                dvdList = dao.getReleasesInLastNYears(numYears);
                request.setAttribute("inputInd", "lastNYears");
                model.addAttribute("dvdList", dvdList);
            } catch (NumberFormatException nfe) {
                model.addAttribute("message", "Please enter an integer");                
            }
        } else if (search.equalsIgnoreCase("mpaaRating")) {
            dvdList = dao.getByRating(searchStr);
            request.setAttribute("inputInd", "mpaaRating");
            model.addAttribute("dvdList", dvdList);
        } else if (search.equalsIgnoreCase("director")) {
            byDirectorMap = dao.getByDirectorGroupByRating(searchStr);
            byDirectorMap2 = dao.getByDirectorGroupByRating2(searchStr);
            request.setAttribute("inputInd", "director");            
            model.addAttribute("dvdMap", byDirectorMap);            
            model.addAttribute("dvdMap2", byDirectorMap2); 
        } else if (search.equalsIgnoreCase("studio")) {
            dvdList = dao.getByStudio(searchStr);
            request.setAttribute("inputInd", "studio");
            model.addAttribute("dvdList", dvdList);
        } else {
            dvdList = dao.listAll();
            request.setAttribute("inputInd", "listAll");
            model.addAttribute("dvdList", dvdList);
        }
        
        return "displayDvds";
    }
    
    @RequestMapping(value = "/editDvdForm", method = RequestMethod.GET)
    public String editDvdForm(@RequestParam("dvdId") int dvdId, Model model) {
        model.addAttribute("dvd", dao.getDvd(dvdId));
        return "editDvdForm";
    }
    
    @RequestMapping(value = "/editDvd", method = RequestMethod.POST)
    public String editDvd(Model model, HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        String searchStr = request.getParameter("searchStr");
        
        String videoType = request.getParameter("videoType");        
        String title = request.getParameter("title");
        String releaseDate = request.getParameter("releaseDate");
        String mpaaRating = request.getParameter("mpaaRating");
        String director = request.getParameter("director");
        String studio = request.getParameter("studio");
        String reviews = request.getParameter("reviews");
        int dvdId = Integer.parseInt(request.getParameter("dvdId"));
        Dvd dvd;
        LocalDate rlseDate = null;
        boolean inputValid = true;
        
        if (title.equalsIgnoreCase("")) {
            model.addAttribute("errorMessage1", "Please enter a movie title.");
            inputValid = false;
        }
        
        try {
            rlseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException dtpe) {
            model.addAttribute("errorMessage2", "Please enter a valid date.");
            inputValid = false;
        }
        
        if (director.equalsIgnoreCase("")) {
            model.addAttribute("errorMessage3", "Please enter director's name.");
            inputValid = false;
        }
        
        if (studio.equalsIgnoreCase("")) {
            model.addAttribute("errorMessage4", "Please enter studio name.");
            inputValid = false;
        }
        dvd = new Dvd();
        dvd.setVideoType(videoType);
        dvd.setTitle(title);
        dvd.setReleaseDate(rlseDate);
        dvd.setMpaaRating(mpaaRating);
        dvd.setDirector(director);
        dvd.setStudio(studio);
        dvd.setReviews(reviews);
        dvd.setDvdId(dvdId);
        if (inputValid) {            
            dao.edit(dvd);
//            return "redirect:searchDvds?search="+search+"&searchStr="+searchStr;
            return "redirect:searchDvds";
        } else {
            model.addAttribute("dvd", dvd);
            return "editDvdForm";
        }
        
    }
    
    @RequestMapping(value = "/deleteDvd", method = RequestMethod.GET)
    public String deleteDvd(@RequestParam("dvdId") int dvdID, Model model) {
        
        dao.remove(dvdID);
        return "redirect:searchDvds";
    }
}
