package ru.kpfu.itis.SoftIlnyr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.entities.Talon;

/**
 * Created by softi on 28.04.2016.
 */
@Repository
public interface TalonsRepository extends JpaRepository<Talon, Integer> {

}
