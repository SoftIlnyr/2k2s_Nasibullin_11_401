package ru.kpfu.itis.SoftIlnyr.services.INTERFACES;

import ru.kpfu.itis.SoftIlnyr.entities.Talon;

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
