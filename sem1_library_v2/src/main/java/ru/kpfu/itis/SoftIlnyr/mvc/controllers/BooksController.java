package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Presence;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.AuthorsService;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.BooksService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Created by softi on 23.04.2016.
 */
@Controller
public class BooksController {
    private static final String IMAGE_PATH = "C:\\Ilnyr\\Programs\\itis\\2k2s\\sem1_library\\src\\main\\webapp\\resources\\uploads\\book_images\\";

    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private BooksService booksService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/tables/books", method = RequestMethod.GET)
    public String booksGet(ModelMap modelMap) {
        List<Book> books = booksService.findAll();
        List<Author> authors = authorsService.findAll();
        modelMap.put("books", books);
        modelMap.put("authors", authors);
        return "/book_table";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tables/books")
    public String bookCreate(@RequestParam String title, @RequestParam String edition, @RequestParam int issue,
                             @RequestParam String language, @RequestParam MultipartFile image, @RequestParam String author, @RequestParam String info) throws IOException {
        Book book = new Book();
        book.setTitle(title);
        book.setEdition(edition);
        book.setIssue(issue);
        book.setLanguage(language);
        book.setRating(0);
        book.setInfo(info);

        String sid = author.split(" ")[0];
        int id = Integer.parseInt(sid);
        Author auth = authorsService.findById(id);
        book.setAuthor(auth);

        if (!image.isEmpty()) {
            String filename = saveImage(image);
            book.setImage(filename);
        }  else {
            book.setImage("default.jpg");
        }

        booksService.addBook(book);

        return "redirect:/tables/books";
    }

    @RequestMapping(value = "/books/{book_id:\\d+}", method = RequestMethod.GET)
    public String bookPage(ModelMap modelMap, @PathVariable int book_id) {
        Book book = booksService.findById(book_id);
        List<Presence> presences = book.getPresence();
        modelMap.put("book", book);
        modelMap.put("authors", authorsService.findAll());
        modelMap.put("presences", presences);
        return "/book_page";
    }

    @RequestMapping(value = "/books/{book_id:\\d+}", method = RequestMethod.POST)
    public String bookUpdate(@PathVariable int book_id, @RequestParam String title, @RequestParam String edition, @RequestParam int issue,
                             @RequestParam String language, @RequestParam MultipartFile image, @RequestParam String author, @RequestParam String info) throws IOException {
        Book book = booksService.findById(book_id);
        book.setTitle(title);
        book.setEdition(edition);
        book.setIssue(issue);
        book.setLanguage(language);
        book.setRating(0);
        book.setInfo(info);

        String sid = author.split(" ")[0];
        int id = Integer.parseInt(sid);
        Author auth = authorsService.findById(id);
        book.setAuthor(auth);

        if (!image.isEmpty()) {
            String filename = saveImage(image);
            book.setImage(filename);
        }

        booksService.updateBook(book);

        return "redirect:/books/" + book_id;
    }

    @RequestMapping(value = "/books/{book_id:\\d+}/{library_id:\\d+}", method = RequestMethod.GET)
    public String talonSendInfo(HttpServletRequest request, @PathVariable int book_id, @PathVariable int library_id, Principal principal) {
        if (principal != null) {
            request.setAttribute("book_id", book_id);
            request.setAttribute("library_id", library_id);
            return "forward:/talons/order";
        } else {
            return "redirect:/login";
        }

    }

    @RequestMapping(value = "/books/{book_id:\\d+}/delete", method = RequestMethod.GET)
    public String bookDelete(@PathVariable int book_id) {
        Book book = booksService.findById(book_id);
        booksService.remove(book);
        return "redirect:/tables/books";
    }

    @RequestMapping(value = "/books/", method = RequestMethod.GET)
    public String bookIndex(ModelMap modelMap) {
        List<Book> books = booksService.findAll();
        modelMap.put("books", books);
        return "book_index";
    }

    private String saveImage(MultipartFile image) throws IOException {
        String rootPath = servletContext.getRealPath("") + "\\resources\\uploads\\book_images";
        String rootPath2 = "C:\\Ilnyr\\Programs\\itis\\2k2s\\sem1_library_v2\\src\\main\\webapp\\resources\\uploads\\book_images";
        rootPath2 = rootPath2.replace("\\", File.separator);
        File dir = new File(rootPath);
        File dir2 = new File(rootPath2);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!dir2.exists()) {
            dir2.mkdirs();
        }
        String filename = String.valueOf(image.hashCode()) + "." + image.getContentType().split("/")[1];
        File file = new File(dir.getAbsolutePath() + File.separator + filename);
        File file2 = new File(dir2.getAbsolutePath() + File.separator + filename);
        FileUtils.writeByteArrayToFile(file, image.getBytes());
        FileUtils.writeByteArrayToFile(file2, image.getBytes());
        return filename;
    }

    @RequestMapping(value = "/tables/books/excel", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
        List<Book> books = booksService.findAll();
        return new ModelAndView("booksView", "books", books);

    }
}
