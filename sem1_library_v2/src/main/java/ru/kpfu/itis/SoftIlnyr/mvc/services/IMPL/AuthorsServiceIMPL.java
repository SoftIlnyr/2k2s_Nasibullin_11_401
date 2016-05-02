package ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.AuthorsRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.AuthorsService;

import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
@Service
@Transactional
public class AuthorsServiceIMPL implements AuthorsService {
    @Autowired
    AuthorsRepository authorsRepository;

    public List<Author> findAll() {
        List<Author> authors = (List<Author>) authorsRepository.findAll();
        return authors;
    }

    public void addAuthor(Author author) {
        authorsRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorsRepository.save(author);
    }

    public void remove(Author author) {
        authorsRepository.delete(author);
    }

    public Author findById(int id) {
        Author author = authorsRepository.findOne(id);
        return author;
    }
}
