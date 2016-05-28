package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.*;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.BooksService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.TalonsService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

import java.io.IOException;
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

    @Autowired
    TalonsService talonsService;

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
    public User makeOrder(@RequestBody Talon talon) {
//        System.out.println(body);
//        Talon talon = null;
//        try {
//            talon = new ObjectMapper().readValue(body, Talon.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(talon.getUser().getNickname());
        talon.setStatus("waiting");

        talonsService.add(talon);
        User user = usersService.findById(talon.getUser().getId());
        return user;
    }
}
