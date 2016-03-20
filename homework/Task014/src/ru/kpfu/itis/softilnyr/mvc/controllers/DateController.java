package ru.kpfu.itis.softilnyr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by softi on 20.03.2016.
 */
@Controller
@RequestMapping("/getdate")
public class DateController {
    @RequestMapping(method = RequestMethod.GET)
    public String datePage(ModelMap model) {
        model.put("time", new java.util.Date());
        return "date";
    }
}
