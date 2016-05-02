package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by softi on 01.05.2016.
 */
@Controller
public class HttpErrorHandler {

    @RequestMapping(value = "/404")
    public String error404() {
        return "404";
    }

    @RequestMapping(value = "/403")
    public String error403() {
        return "403";
    }
}
