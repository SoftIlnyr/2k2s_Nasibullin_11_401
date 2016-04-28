package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.*;
import ru.kpfu.itis.SoftIlnyr.mvc.services.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 23.04.2016.
 */
@Controller
public class TalonsController {

    @Autowired
    BooksService booksService;

    @Autowired
    UsersService usersService;

    @Autowired
    LibrariesService librariesService;

    @Autowired
    TalonsService talonsService;

    @RequestMapping(value = "/tables/talons", method = RequestMethod.GET)
    public String talonsGet() {
        return "/talon_table";
    }

    @RequestMapping(value = "/talons/order", method = RequestMethod.GET)
    public String talonForm(HttpServletRequest request, ModelMap modelMap) {
        Integer book_id = (Integer) request.getAttribute("book_id");
        Book book = booksService.findById(book_id);

        Integer library_id = (Integer) request.getAttribute("library_id");
        Library prechosedLibrary = librariesService.findById(library_id);
        List<Library> libraries = new ArrayList<Library>();
        for (Presence presence : book.getPresence()) {
            libraries.add(presence.getLibrary());
        }

        modelMap.put("book", book);
        modelMap.put("prLib", prechosedLibrary);
        modelMap.put("libraries", libraries);

        return "talon_order";
    }

    @RequestMapping(value = "/talons/order", method = RequestMethod.POST)
    public String talonAdd(@RequestParam String book, @RequestParam String library, @RequestParam int period) {
        Talon talon = new Talon();
        int book_id = Integer.parseInt(book.split(" ")[0]);
        int library_id = Integer.parseInt(library.split(" ")[0]);
        talon.setLibrary(librariesService.findById(library_id));
        talon.setBook(booksService.findById(book_id));
        talon.setPeriod(period);
        talon.setStatus("waiting");
        User user = usersService.findById(0);
        talon.setUser(user);
        talonsService.add(talon);

        return "redirect:/books/" + book_id;
    }


}
