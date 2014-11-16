package com.swcguild.myscarletexpo.controller;


import com.swcguild.myscarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.myscarletexpo.model.Category;
import com.swcguild.myscarletexpo.model.Product;
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
public class CategoryController {

    private ScarletExpoDao scarletExpoDao;

    @Inject
    public void setScarletExpoDao(ScarletExpoDao scarletExpoDao) {
        this.scarletExpoDao = scarletExpoDao;
    }

    @RequestMapping(value = "/addCategoryForm", method = RequestMethod.GET)
    public String addCategoryForm(Model model) {

        model.addAttribute("category", new Category());
        return "Portal/addCategoryForm";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "Portal/addCategoryForm";
        }

        try {
            if (scarletExpoDao.getCategoryByName(category.getCategoryName()) == null) {
                scarletExpoDao.addNewCategory(category);
                model.addAttribute("message", "Successfully added.");
                return "redirect:addCategoryForm";
            } else {
                model.addAttribute("message", "Category name already exists.");
                return "Portal/addCategoryForm";
            }
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "Portal/addCategoryForm";
        }
    }

    @RequestMapping(value = "/editCategoryForm", method = RequestMethod.GET)
    public String editCategoryForm(@RequestParam("categoryId") int categoryId, Model model) {
        Category category = scarletExpoDao.getCategoryById(categoryId);        
        model.addAttribute("category", category);
        return "Portal/editCategoryForm";
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.POST)
    public String editCategory(@Valid Category category, BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            return "Portal/editCategoryForm";
        }
        try {           
            if (scarletExpoDao.getCategoryByName(category.getCategoryName()) == null) {
                scarletExpoDao.updateCategory(category);
                model.addAttribute("message", "Successfully updated.");
                return "redirect:displayCategories";
            } else {
                model.addAttribute("message", "Category by that name already exists. Name not updated");
                return "Portal/editCategoryForm";
            }
            
        } catch (Exception e) {
            model.addAttribute("Message", e.getMessage());
            return "Portal/editCategoryForm";
        }
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
    public String deleteCategory(@RequestParam("categoryId") int categoryId, Model model) {
        List<Product> pList = scarletExpoDao.getProductsByCategoryId(categoryId);
       
        if (pList == null || pList.isEmpty()) {
            try {
                scarletExpoDao.removeCategory(categoryId);
                model.addAttribute("message", "Successfully deleted.");
            } catch (Exception e) {
                model.addAttribute("message", e.getMessage());
                return "Portal/displayCategories";
            }
        } else {
            model.addAttribute("message", "Category has product items. Cannot be deleted.");
        }
        return "redirect:displayCategories";
    }
    
    @RequestMapping(value = "/displayCategories", method = RequestMethod.GET)
    public String displayCategories(Model model) {
        List<Category> categories = scarletExpoDao.getAllCategories();
        
        model.addAttribute("categories", categories);
        return "Portal/displayCategories";
    }
        
}
