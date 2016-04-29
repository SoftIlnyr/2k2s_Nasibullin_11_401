package ru.kpfu.itis.SoftIlnyr.mvc.services;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Talon;

import java.util.List;

/**
 * Created by softi on 28.04.2016.
 */
@Service
public interface TalonsService {

    void add(Talon talon);


    List<Talon> findAll();

    Talon findById(int talon_id);

    void update(Talon talon);
}
