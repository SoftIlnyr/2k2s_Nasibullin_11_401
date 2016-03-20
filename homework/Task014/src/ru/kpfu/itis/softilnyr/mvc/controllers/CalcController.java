package ru.kpfu.itis.softilnyr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by softi on 20.03.2016.
 */
@Controller
@RequestMapping("/{operation:add|mult}/{arg1:\\d+}/{arg2:\\d+}")
public class CalcController {
    @RequestMapping(method = RequestMethod.GET)
    public String calculate(ModelMap model, @PathVariable String operation, @PathVariable int arg1, @PathVariable int arg2) {
        if ("mult".equals(operation)) {
            model.put("result", arg1 * arg2);
        }
        if ("add".equals(operation)) {
            model.put("result", arg1 + arg2);
        }
        return "calc";
    }
}
