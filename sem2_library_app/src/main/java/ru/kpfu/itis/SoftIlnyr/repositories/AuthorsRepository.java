package ru.kpfu.itis.SoftIlnyr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.entities.Author;

import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer> {
    List<Author> findAll();

    Author save(Author author);

}
