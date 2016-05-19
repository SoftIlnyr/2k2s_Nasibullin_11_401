package ru.kpfu.itis.SoftIlnyr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.entities.Presence;

/**
 * Created by softi on 27.04.2016.
 */
@Repository
public interface PresenceRepository extends JpaRepository<Presence, Integer> {

}
