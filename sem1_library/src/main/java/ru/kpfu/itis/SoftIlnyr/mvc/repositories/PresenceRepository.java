package ru.kpfu.itis.SoftIlnyr.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Presence;

/**
 * Created by softi on 27.04.2016.
 */
@Repository
public interface PresenceRepository extends CrudRepository<Presence, Integer> {

}
