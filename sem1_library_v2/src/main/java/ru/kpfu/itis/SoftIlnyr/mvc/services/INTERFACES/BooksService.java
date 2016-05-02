package ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;

import java.util.List;

/**
 * Created by softi on 24.04.2016.
 */
public interface BooksService {
    void addBook(Book book);

    Book findById(int id);

    List<Book> findAll();

    void updateBook(Book book);

    void remove(Book book);
}
