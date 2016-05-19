package ru.kpfu.itis.SoftIlnyr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.entities.Library;

/**
 * Created by softi on 25.04.2016.
 */
@Repository
public interface LibrariesRepository extends JpaRepository<Library, Integer> {

}
