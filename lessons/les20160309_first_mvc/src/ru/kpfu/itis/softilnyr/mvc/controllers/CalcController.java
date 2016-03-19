package ru.kpfu.itis.softilnyr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by softi on 09.03.2016.
 */
@Controller
@RequestMapping("/calc")
public class CalcController {
    @RequestMapping(method = RequestMethod.GET)
    public String calcPage(ModelMap model) {
        return "calc";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculation(ModelMap model, @RequestParam String arg1, @RequestParam String arg2, @RequestParam String act) {
        double a1 = Double.parseDouble(arg1);
        double a2 = Double.parseDouble(arg2);
        double res = 0;
        switch (act) {
            case "+":
                res = a1 + a2;
                break;
            case "-":
                res = a1 - a2;
                break;
            case "*":
                res = a1 * a2;
                break;
            case "/":
                res = a1 / a2;
                break;
        }
        model.put("result", res);
        return "calc";
    }
}
