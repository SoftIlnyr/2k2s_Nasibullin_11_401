package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;
import ru.kpfu.itis.SoftIlnyr.mvc.services.AuthorsService;

import java.util.List;

/**
 * Created by softi on 16.04.2016.
 */
@Controller
@Configuration
@ComponentScan("ru.kpfu.itis.SoftIlnyr.mvc.services")
public class MainController {

    @Autowired
    private AuthorsService authorsService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String mainPath(ModelMap modelMap) {
        List<Author> authors = authorsService.findAll();
        modelMap.put("authors", authors);
        return "test";
    }

}
