package ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.BooksRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.BooksService;

import java.util.List;

/**
 * Created by softi on 24.04.2016.
 */

@Service
@Transactional
public class BooksServiceIMPL implements BooksService {

    @Autowired
    public BooksRepository booksRepository;

    public void addBook(Book book) {
        booksRepository.save(book);
    }

    public Book findById(int id) {
        Book book = booksRepository.findOne(id);
        return book;
    }

    public List<Book> findAll() {
        List<Book> books = (List<Book>) booksRepository.findAll();
        return books;
    }

    public void updateBook(Book book) {
        booksRepository.save(book);
    }

    public void remove(Book book) {
        booksRepository.delete(book);
    }
}
