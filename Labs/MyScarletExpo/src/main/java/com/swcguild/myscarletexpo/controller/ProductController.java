package com.swcguild.myscarletexpo.controller;

import com.swcguild.myscarletexpo.dao.interfaces.ScarletExpoDao;
import com.swcguild.myscarletexpo.model.Category;
import com.swcguild.myscarletexpo.model.Product;
import com.swcguild.myscarletexpo.model.ProductItem;
import com.swcguild.myscarletexpo.model.User;
import com.swcguild.myscarletexpo.model.view.ProductItemView;
import com.swcguild.myscarletexpo.model.view.ProductView;
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
public class ProductController {

    private ScarletExpoDao scarletExpoDao;

    @Inject
    public void setScarletExpoDao(ScarletExpoDao scarletExpoDao) {
        this.scarletExpoDao = scarletExpoDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, Model model) {
        return "adminPortal";
    }

    @RequestMapping(value = "/addProductForm", method = RequestMethod.GET)
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categories = scarletExpoDao.getAllCategories();

        model.addAttribute("categories", categories);

        return "Portal/addProductForm";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
//    public String addProduct(@ModelAttribute("product") Product product, Model model) {
    public String addProduct(@Valid Product product, BindingResult result, Model model) {
        List<Category> categories;

        if (result.hasErrors()) {
            categories = scarletExpoDao.getAllCategories();
            model.addAttribute("categories", categories);
            return "Portal/addProductForm";
        }

        try {
            if (scarletExpoDao.getProductByName(product.getProductName()) == null) {
                scarletExpoDao.addNewProduct(product);
                return "redirect:addProductForm?message=Successfully added.";
            } else {
                categories = scarletExpoDao.getAllCategories();
                model.addAttribute("categories", categories);
                model.addAttribute("message", "Product already exists.");
                return "Portal/addProductForm";
            }
        } catch (Exception e) {
            categories = scarletExpoDao.getAllCategories();
            model.addAttribute("categories", categories);
            model.addAttribute("message", e.getMessage());
            return "Portal/addProductForm";
        }
    }

    @RequestMapping(value = "/editProductForm", method = RequestMethod.GET)
    public String editProductForm(@RequestParam("productId") int productId, Model model) {
        Product p = scarletExpoDao.getProductById(productId);
        List<Category> categories = scarletExpoDao.getAllCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("product", p);
        return "Portal/editProductForm";
    }

    @RequestMapping(value = "editProduct", method = RequestMethod.POST)
    public String editProductForm(@Valid Product product, BindingResult result, Model model) {
        List<Category> categories;
        Product p;

        if (result.hasErrors()) {
            categories = scarletExpoDao.getAllCategories();
            model.addAttribute("categories", categories);
            return "Portal/editProductForm";
        }

        p = scarletExpoDao.getProductByName(product.getProductName());
        try {
            if (p == null || (p.getProductId() == product.getProductId())) {
                scarletExpoDao.updateProduct(product);                
                return "redirect:displayProductList?message=Successfully updated.";
            } else {
                categories = scarletExpoDao.getAllCategories();
                model.addAttribute("categories", categories);
                model.addAttribute("message", "Product by that name already exists.");
                return "Portal/editProductForm";
            }
        } catch (Exception e) {
            categories = scarletExpoDao.getAllCategories();
            model.addAttribute("categories", categories);
            model.addAttribute("message", e.getMessage());
            return "Portal/editProductForm";
        }
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("productId") int productId, Model model) {
        String message = "";
//        if (scarletExpoDao.getProductItemByProductId(productId).isEmpty()) {
            scarletExpoDao.deleteProduct(productId);
            message = "Successfully deleted.";
//        } else {
//            message = "Product has product items. Cannot be deleted.";
//        }
        return "redirect:displayProductList?message="+message;
    }

    @RequestMapping(value = "/displayProductList", method = RequestMethod.GET)
    public String displayProductList(Model model) {
        List<ProductView> productViewList = scarletExpoDao.displayAllProducts();

//        Map<Integer, List<ProductItem>> productItemViewList = new HashMap<>();
//        List<ProductItem> productItemList = new ArrayList<>();
//        int productId;
//        int[] notesId;
//        for (ProductView pv : productViewList) {
//            productId = pv.getProductId();
//            productItemList = scarletExpoDao.getProductItemByProductId(productId);
//            productItemViewList.put(productId, productItemList);
//            for (ProductItem pi : productItemList) {
//                notesId = pi.getNoteIds();
//            }
//        }
        model.addAttribute("productViewList", productViewList);
        return "Portal/displayProductList";
    }

    @RequestMapping(value = "/displayProductItemList", method = RequestMethod.GET)
    public String displayProductItemList(@RequestParam("productId") int productId, Model model) {

        List<ProductItemView> productItemViewList = scarletExpoDao.displayProductItemsByProductId(productId);

        model.addAttribute("productItemViewList", productItemViewList);
        return "Portal/displayProductItemList";
    }

    @RequestMapping(value = "/addProductItemForm", method = RequestMethod.GET)
    public String addProductItemForm(Model model) {
        model.addAttribute("productItem", new ProductItem());

        return "Portal/addProductItemForm";
    }

    @RequestMapping(value = "/addProductItem", method = RequestMethod.POST)
//    public String addProduct(@ModelAttribute("product") Product product, Model model) {
    public String addProductItem(@Valid Product product, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "Portal/addProductItemForm";
        }

        try {
//            scarletExpoDao.;
            return "redirect:addProductItemForm?message=Successfully added.";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "Portal/addProductItemForm";
        }
    }

    @RequestMapping(value = "/editProductItemForm", method = RequestMethod.GET)
    public String updateProductItemForm(@RequestParam("productItemId") int productItemId, Model model) {
        ProductItem pi = scarletExpoDao.getProductItemById(productItemId);
        model.addAttribute("productItem", pi);
        return "Portal/editProductItemForm";
    }

    @RequestMapping(value = "/editProductItem", method = RequestMethod.POST)
    public String updateProductItem(@Valid ProductItem productItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Portal/editProductItemForm";
        }

        try {
            scarletExpoDao.updateProductItem(productItem);
            model.addAttribute("message", "Succesffully updated.");
            return "redirect:displayProductItemList?productItem="+productItem;
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "Portal/editProductItemForm";
        }
    }
}
