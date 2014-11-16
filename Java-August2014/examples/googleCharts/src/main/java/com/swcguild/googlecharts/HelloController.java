package com.swcguild.googlecharts;

import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.TableRow;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.render.JsonRenderer;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/hello"})
public class HelloController {

    public HelloController() {
    }

    @RequestMapping(value = "/sayhi", method = RequestMethod.GET)
    public String sayHi(Map<String, Object> model) {
        model.put("message", "Hello from the controller");
        return "hello";
    }

    // this method is a REST web service endpoint
    // the @RequestMapping annotation for REST endpoints is the same as for 
    // web page endpoints
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    // the @ResponseBody annotation tells Spring MVC that the value returned from
    // this method is NOT the name of a View component.  The value returned should
    // be the body of the response to the caller
    @ResponseBody
    public String getDataTable() {
        try {
            // We're hard coding a DataTable object here.  In a real application
            // the DAO would return a populated DataTable to the controller
            DataTable t = new DataTable();
            t.addColumn(new ColumnDescription("Asset_ID", ValueType.TEXT, "Asset ID"));
            t.addColumn(new ColumnDescription("Damage_Rating", ValueType.NUMBER, "Damage Rating"));
            TableRow tr = new TableRow();
            tr.addCell("Canoe1");
            tr.addCell(1);
            t.addRow(tr);
            tr = new TableRow();
            tr.addCell("Tent1");
            tr.addCell(6);
            t.addRow(tr);
            
            // use the Jsonrenderer to convert the DataTable to a JSON string
            // the default Jackson converter doesn't convert the DataTable object
            // to JSON properly so we have to do it here.
            return JsonRenderer.renderDataTable(t, true, false, false).toString();
        } catch (Exception e) {
            // just return an error string if we encounter an issue
            return "Invalid Data";
        }
    }
}
