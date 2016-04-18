package kpfu.SoftIlnyr.mvc.repositories;

import kpfu.SoftIlnyr.mvc.entities.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by softi on 13.04.2016.
 */
public interface StudentsRepository extends JpaRepository<StudentsEntity, Long> {
    List<StudentsEntity> findAll();

}
