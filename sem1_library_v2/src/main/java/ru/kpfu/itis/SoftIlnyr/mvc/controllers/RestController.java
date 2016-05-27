package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.*;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.BooksService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

import java.security.Principal;
import java.util.List;

/**
 * Created by softi on 25.05.2016.
 */
@RequestMapping(value = "/rest")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    BooksService booksService;

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/info")
    public @ResponseBody List<Book> getInfo() {
        List<Book> bookList = booksService.findAll();
        System.out.println(bookList);
        return bookList;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public
    @ResponseBody
    User gertUser() {
        String nickname = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getNickname();
        System.out.println(nickname);
        User user = usersService.findByNickname(nickname);
        return user;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public void makeOrder(@RequestParam("book") int book, @RequestParam("library") int library, @RequestParam("period") int period, Principal principal) {
        if (principal == null) {
            return;
        }

        System.out.println(book + ":" + library + ":" + period);
        return;

    }
}
