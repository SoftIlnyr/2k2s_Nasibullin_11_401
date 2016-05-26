package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.BooksService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
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
//        System.out.println("Post");
//        System.out.println(nickname);
//        User user = usersService.findByNickname(nickname);

//        String nickname = request.getParameter("nickname");
//        String password = request.getParameter("password");
//        User user = usersService.findByNickname(nickname);
//        String info = request.getHeader("Authorization");
//        byte[] valueDecoded = Base64.getDecoder().decode(info);
//        String decodedInfo = new String(valueDecoded);
//        System.out.println(decodedInfo);
//        User user = usersService.findByNickname()
//        System.out.println(info);
        return user;
    }
}
