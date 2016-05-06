package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Library;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Presence;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.BooksService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.LibrariesService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.PresenceService;

import java.util.List;

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

        int book_id = Integer.parseInt(book.split(" ")[0]);
        Book book1 = booksService.findById(book_id);
        int library_id = Integer.parseInt(library.split(" ")[0]);
        Library library1 = librariesService.findById(library_id);

        Presence presence = searchPresence(book1, library1);
        if (presence == null) {
            presence = new Presence();
            presence.setBook(book1);
            presence.setLibrary(library1);
            presence.setAmount(amount);
        } else {
            presence.setAmount(presence.getAmount() + amount);
        }

        presenceService.addPresence(presence);

        return "redirect:/tables/presences";
    }

    private Presence searchPresence(Book book1, Library library1) {
        Presence presence = null;
        for (Presence p : book1.getPresence()) {
            if (p.getLibrary().getId() == library1.getId()) {
                presence = p;
                break;
            }
        }
        return presence;
    }

    @RequestMapping(value = "/tables/presences/excel", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
        List<Presence> presences = presenceService.findAll();
        return new ModelAndView("presencesView", "presences", presences);

    }
}
