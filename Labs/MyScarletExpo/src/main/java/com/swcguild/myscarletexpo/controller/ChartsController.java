package com.swcguild.myscarletexpo.controller;

import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.render.JsonRenderer;
import com.swcguild.myscarletexpo.dao.interfaces.ChartsDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/charts"})
public class ChartsController {

    //need to use dependency injection? ---ask Kevin/Josephine 
//    ChartsDaoImpl chdaoImpl = new ChartsDaoImpl();

 private ChartsDao dao;  
    @Inject
    public void setChartsDao(ChartsDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/chartA", method = RequestMethod.GET)
    @ResponseBody
    public String DataTableA() {
        try {
            DataTable t = dao.getReportA();
            return JsonRenderer.renderDataTable(t, true, false, false).toString();
           
        } catch (Exception e) {
            return "Invalid Data";
        }

    }

}
