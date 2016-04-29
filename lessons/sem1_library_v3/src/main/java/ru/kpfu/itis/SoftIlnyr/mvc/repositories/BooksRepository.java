package ru.kpfu.itis.SoftIlnyr.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Book;

import java.util.List;

/**
 * Created by softi on 24.04.2016.
 */
@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    Book save(Book book);

    List<Book> findAll();

}
