package ru.kpfu.SoftIlnyr.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.SoftIlnyr.mvc.entities.ClassesEntity;

/**
 * Created by softi on 13.04.2016.
 */
public interface ClassesRepository extends JpaRepository<ClassesEntity, Long> {
}
