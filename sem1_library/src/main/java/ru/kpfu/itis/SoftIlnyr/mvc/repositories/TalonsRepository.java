package ru.kpfu.itis.SoftIlnyr.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Talon;

/**
 * Created by softi on 28.04.2016.
 */
@Repository
public interface TalonsRepository extends CrudRepository<Talon, Integer> {

}
