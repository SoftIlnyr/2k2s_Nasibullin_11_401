package ru.kpfu.SoftIlnyr.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.SoftIlnyr.mvc.entities.TeachersEntity;

/**
 * Created by softi on 13.04.2016.
 */
public interface TeachersRepository extends JpaRepository<TeachersEntity, Long> {
}
