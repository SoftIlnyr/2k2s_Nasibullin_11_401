package ru.kpfu.itis.SoftIlnyr.services.INTERFACES;

import ru.kpfu.itis.SoftIlnyr.entities.Book;

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
