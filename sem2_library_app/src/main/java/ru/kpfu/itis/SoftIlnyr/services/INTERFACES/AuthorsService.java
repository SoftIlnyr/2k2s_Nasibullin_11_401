package ru.kpfu.itis.SoftIlnyr.services.INTERFACES;

import ru.kpfu.itis.SoftIlnyr.entities.Author;

import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
public interface AuthorsService {
    List<Author> findAll();

    Author findById(int id);

    void addAuthor(Author author);

    void updateAuthor(Author author);

    void remove(Author author);
}
