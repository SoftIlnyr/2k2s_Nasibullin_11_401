package ru.kpfu.itis.SoftIlnyr.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.AuthorsRepository;

import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
public class AuthorsServiceIMPL implements AuthorsService {

    @Autowired
    AuthorsRepository authorsRepository;

    public List<Author> findAll() {
        List<Author> authors = (List<Author>) authorsRepository.findAll();
        return authors;
    }

    public Author findById(Long id) {
        return null;
    }

    public Author findById(int id) {
        Author author = authorsRepository.findOne((long) id);
        return author;
    }
}
