package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.AuthorsService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

import java.security.Principal;
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

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String mainPath(ModelMap modelMap, Principal principal) {
        List<Author> authors = authorsService.findAll();
        modelMap.put("authors", authors);
        return "test";
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public String handle404Exception() {
        return "404";
    }

}
