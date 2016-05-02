package ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Talon;

import java.util.List;

/**
 * Created by softi on 28.04.2016.
 */
public interface TalonsService {

    void add(Talon talon);

    List<Talon> findAll();

    Talon findById(int talon_id);

    void update(Talon talon);
}
