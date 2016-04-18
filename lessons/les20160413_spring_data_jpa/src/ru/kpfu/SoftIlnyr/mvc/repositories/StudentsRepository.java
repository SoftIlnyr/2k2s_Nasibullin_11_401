package ru.kpfu.SoftIlnyr.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.SoftIlnyr.mvc.entities.StudentsEntity;

import java.util.List;

/**
 * Created by softi on 13.04.2016.
 */
public interface StudentsRepository extends JpaRepository<StudentsEntity, Long> {
    List<StudentsEntity> findAll();

}
