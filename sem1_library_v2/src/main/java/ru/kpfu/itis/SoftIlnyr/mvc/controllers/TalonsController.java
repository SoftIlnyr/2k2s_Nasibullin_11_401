package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.*;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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

    @Autowired
    PresenceService presenceService;


    @RequestMapping(value = "/tables/talons", method = RequestMethod.GET)
    public String talonsGet(ModelMap modelMap) {
        List<Talon> talons = talonsService.findAll();
        modelMap.put("talons", talons);
        return "/talon_table";
    }

    @RequestMapping(value = "/talons/order", method = RequestMethod.GET)
    public String talonForm(HttpServletRequest request, ModelMap modelMap) {
        Integer book_id = (Integer) request.getAttribute("book_id");
        Book book = null;
        if (book_id != null) {
            book = booksService.findById(book_id);
        }

        Integer library_id = (Integer) request.getAttribute("library_id");
        Library prechosedLibrary = null;
        if (library_id != null) {
            prechosedLibrary = librariesService.findById(library_id);
        }
//        List<Library> libraries = new ArrayList<Library>();
//        for (Presence presence : book.getPresence()) {
//            libraries.add(presence.getLibrary());
//        }

        List<Book> books = booksService.findAll();
        modelMap.put("books", books);
        modelMap.put("book", book);
        modelMap.put("prLib", prechosedLibrary);
//        modelMap.put("libraries", libraries);

        return "talon_order";
    }

    @RequestMapping(value = "/talons/order/libraries", method = RequestMethod.POST)
    public @ResponseBody List<Library> getPresences(@RequestBody String bookinfo) {
        String book_id = bookinfo.replace("\"", "").split(" ")[0];
        Book book = booksService.findById(Integer.parseInt(book_id));
        List<Library> libraries = new ArrayList<>();
        for (Presence presence : book.getPresence()) {
            Library library = presence.getLibrary();
            if (!libraries.contains(library)) {
                libraries.add(library);
            }
        }
        return libraries;
    }

    @RequestMapping(value = "/talons/order", method = RequestMethod.POST)
    public String talonAdd(@RequestParam String book, @RequestParam String library, @RequestParam int period, Principal principal) {
        Talon talon = new Talon();
        int book_id = Integer.parseInt(book.split(" ")[0]);
        int library_id = Integer.parseInt(library.split(" ")[0]);
        talon.setLibrary(librariesService.findById(library_id));
        talon.setBook(booksService.findById(book_id));
        talon.setPeriod(period);
        talon.setStatus("waiting");

        User user = (User) ((Authentication) principal).getPrincipal();
        talon.setUser(user);
        talonsService.add(talon);

        return "redirect:/books/" + book_id;
    }

    @RequestMapping(value = "/talons/{talon_id:\\d+}", method = RequestMethod.GET)
    public String talonPage(ModelMap modelMap, @PathVariable int talon_id) {
        Talon talon = talonsService.findById(talon_id);
        modelMap.put("talon", talon);
        return "talon_update";
    }

    @RequestMapping(value = "/talons/{talon_id:\\d+}", method = RequestMethod.POST)
    public String talonUpdate(@PathVariable int talon_id, @RequestParam String book, @RequestParam String library, @RequestParam String status) {
        Talon talon = talonsService.findById(talon_id);
        if ("taken".equals(status.toLowerCase())) {
            for (Presence presence : talon.getLibrary().getPresence()) {
                if (presence.getBook() == talon.getBook()) {
                    presence.setAmount(presence.getAmount() - 1);
                    presenceService.update(presence);
                    break;
                }
            }
            talon.setStatus(status);
        } else if ("returned".equals(status.toLowerCase())) {
            for (Presence presence : talon.getLibrary().getPresence()) {
                if (presence.getBook() == talon.getBook()) {
                    presence.setAmount(presence.getAmount() + 1);
                    presenceService.update(presence);
                    break;
                }
            }
            talon.setStatus(status);
        }
        talonsService.update(talon);

        return "redirect:/tables/talons";
    }


}
