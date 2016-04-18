package ru.kpfu.itis.SoftIlnyr.mvc.services;

import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;

import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
public interface AuthorsService {
    List<Author> findAll();

    Author findById(Long id);
}
