package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Library;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Presence;
import ru.kpfu.itis.SoftIlnyr.mvc.services.BooksService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.LibrariesService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.PresenceService;

/**
 * Created by softi on 27.04.2016.
 */
@Controller
public class PresenceController {
    @Autowired
    private BooksService booksService;

    @Autowired
    private LibrariesService librariesService;

    @Autowired
    private PresenceService presenceService;

    @RequestMapping(value = "/tables/presences", method = RequestMethod.GET)
    public String presenceGet(ModelMap modelMap) {
        modelMap.put("books", booksService.findAll());
        modelMap.put("libraries", librariesService.findAll());
        modelMap.put("presences", presenceService.findAll());
        return "presence_table";
    }

    @RequestMapping(value = "/tables/presences", method = RequestMethod.POST)
    public String presenceAdd(@RequestParam String book, @RequestParam String library, @RequestParam int amount) {

        Presence presence = new Presence();
        int book_id = Integer.parseInt(book.split(" ")[0]);
        Book book1 = booksService.findById(book_id);
        int library_id = Integer.parseInt(library.split(" ")[0]);
        Library library1 = librariesService.findById(library_id);
        presence.setBook(book1);
        presence.setLibrary(library1);
        presence.setAmount(amount);

        presenceService.addPresence(presence);

        return "redirect:/tables/presences";
    }
}
