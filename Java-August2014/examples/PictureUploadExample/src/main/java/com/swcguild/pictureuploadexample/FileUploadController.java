package com.swcguild.pictureuploadexample;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    public FileUploadController() {
    }

    @RequestMapping(value = "/fileUploadForm", method = RequestMethod.GET)
    public String fileUploadForm(Model model) {
        return "fileUploadForm";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest req, 
            Model model, 
            @RequestParam("name") String name, 
            @RequestParam("uploadFile") MultipartFile file) {

        // only save the file if the user actually uploaded something
        if (!file.isEmpty()) {
            try {
                // add the filename to the model so we can display it on the success page
                model.addAttribute("fileName", name);
                // we want to put the uploaded image into the 'images' folder of our application
                String savePath = req.getSession().getServletContext().getRealPath("/") + "images/";
                File dir = new File(savePath);
                // if 'images' directory is not there, go ahead and create it
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                
                // transfer the contents of the uploaded file to the server
                file.transferTo(new File(savePath + name));
                
                // the success page uses this value in the src attribute of the 
                // img tag so it can display the newly uploaded file
                model.addAttribute("imageRef", "../images/" + name);
                return "fileUploadSuccess";
            } catch (Exception e) {
                // if we encounter an exception, add the error message to the model
                // and return back to the file upload form page
                model.addAttribute("errorMsg", "File upload failed: " + e.getMessage());
                return "fileUploadForm";
            }
        } else {
            // if the user didn't upload anything, add the error message to the model
            // and return back to the file upload form page
            model.addAttribute("errorMsg", "Please specify a non-empty file.");
            return "fileUploadForm";
        }
    }
}
