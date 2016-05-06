package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.AuthorsService;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by softi on 23.04.2016.
 */
@Controller
public class AuthorsController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private AuthorsService authorsService;


    @RequestMapping(value = "/tables/authors", method = RequestMethod.GET)
    public String authorsGet(ModelMap modelMap) {
        modelMap.put("authors", authorsService.findAll());
        return "/author_table";
    }

    @RequestMapping(value = "/tables/authors", method = RequestMethod.POST)
    public String authorCreate(@RequestParam String name, @RequestParam String surname,
                               @RequestParam String info, @RequestParam MultipartFile image) throws IOException {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        author.setInfo(info);
        if (!image.isEmpty()) {
            String filename = saveImage(image);
            author.setPhoto(filename);
        } else {
            author.setPhoto("default.jpg");
        }

        authorsService.addAuthor(author);

        return "redirect:/tables/authors";
    }

    @RequestMapping(value = "/authors/{author_id:\\d+}", method = RequestMethod.GET)
    public String authorPage(ModelMap modelMap, @PathVariable int author_id) {
        Author author = authorsService.findById(author_id);
        modelMap.put("author", author);
        List<Book> books = author.getBooks();
        modelMap.put("books", books);
        return "/author_page";
    }

    @RequestMapping(value = "/authors/{author_id:\\d+}", method = RequestMethod.POST)
    public String authorUpdate(@PathVariable int author_id, @RequestParam String name, @RequestParam String surname,
                               @RequestParam String info, @RequestParam MultipartFile image) throws IOException {
        Author author = authorsService.findById(author_id);
        author.setName(name);
        author.setSurname(surname);
        author.setInfo(info);
        if (!image.isEmpty()) {
            String filename = saveImage(image);
            author.setPhoto(filename);
        }

        authorsService.updateAuthor(author);
        return "redirect:/authors/" + author_id;
    }

    @RequestMapping(value = "/auhors/", method = RequestMethod.GET)
    public String bookIndex(ModelMap modelMap) {
        List<Author> authors = authorsService.findAll();
        modelMap.put("authors", authors);
        return "author_index";
    }

    @RequestMapping(value = "/authors/{author_id:\\d+}/delete", method = RequestMethod.GET)
    public String authorDelete(@PathVariable int author_id) {
        Author author = authorsService.findById(author_id);
        authorsService.remove(author);
        return "redirect:/tables/authors";
    }

    private String saveImage(MultipartFile image) throws IOException {
        String rootPath = servletContext.getRealPath("") + "resources\\uploads\\author_images";
        String rootPath2 = "C:\\Ilnyr\\Programs\\itis\\2k2s\\sem1_library_v2\\src\\main\\webapp\\resources\\uploads\\author_images";
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

}
