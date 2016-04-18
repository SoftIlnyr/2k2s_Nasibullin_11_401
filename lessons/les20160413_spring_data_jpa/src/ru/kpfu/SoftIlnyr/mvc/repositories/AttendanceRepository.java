package ru.kpfu.SoftIlnyr.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import ru.kpfu.SoftIlnyr.mvc.entities.AttendanceEntity;

/**
 * Created by softi on 13.04.2016.
 */
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
}
