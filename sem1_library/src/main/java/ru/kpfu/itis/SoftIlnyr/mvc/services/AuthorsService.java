package ru.kpfu.itis.SoftIlnyr.mvc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;

import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
@Service
@Transactional
public interface AuthorsService {
    List<Author> findAll();

    Author findById(int id);

    void addAuthor(Author author);

    void updateAuthor(Author author);

    void remove(Author author);
}
