package ru.kpfu.itis.SoftIlnyr.mvc.services;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Talon;

/**
 * Created by softi on 28.04.2016.
 */
@Service
public interface TalonsService {

    void add(Talon talon);
}
