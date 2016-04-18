package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.AuthorsRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.AuthorsService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.AuthorsServiceIMPL;

import java.util.List;

/**
 * Created by softi on 16.04.2016.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String mainPath(ModelMap modelMap) {
        AuthorsService authorsService = new AuthorsServiceIMPL();

        List<Author> author = authorsService.findAll();
        modelMap.put("author", author);
        return "test";
    }

}
