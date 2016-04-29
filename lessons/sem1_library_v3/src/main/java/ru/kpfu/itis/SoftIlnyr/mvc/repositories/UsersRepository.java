package ru.kpfu.itis.SoftIlnyr.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;

/**
 * Created by softi on 24.04.2016.
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}
