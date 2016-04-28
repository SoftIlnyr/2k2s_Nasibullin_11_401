package ru.kpfu.itis.SoftIlnyr.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;

import java.util.List;

/**
 * Created by softi on 24.04.2016.
 */
@Repository
public interface BooksRepository extends CrudRepository<Book, Integer> {
    Book save(Book book);

    Iterable<Book> findAll();

}
