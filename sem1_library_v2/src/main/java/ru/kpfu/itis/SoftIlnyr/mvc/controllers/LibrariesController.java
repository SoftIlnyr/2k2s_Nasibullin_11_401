package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Library;
import ru.kpfu.itis.SoftIlnyr.mvc.services.LibrariesService;

/**
 * Created by softi on 23.04.2016.
 */
@Controller
@RequestMapping(value = "/tables/libraries")
public class LibrariesController {

    @Autowired
    private LibrariesService librariesService;

    @RequestMapping(method = RequestMethod.GET)
    public String librariesGet(ModelMap modelMap) {
        modelMap.put("libraries", librariesService.findAll());
        return "/library_table";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String libraryCreate(@RequestParam String name, @RequestParam String address) {
        Library library = new Library();
        library.setAddress(address);
        library.setName(name);
        librariesService.addLibrary(library);
        return "redirect:/tables/libraries";
    }
}
