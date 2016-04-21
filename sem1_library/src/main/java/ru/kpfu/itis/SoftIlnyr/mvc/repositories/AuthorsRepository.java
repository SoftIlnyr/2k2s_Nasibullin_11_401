package ru.kpfu.itis.SoftIlnyr.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Author;

import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
@Repository
public interface AuthorsRepository extends CrudRepository<Author, Long>{
    public Iterable<Author> findAll();
}
