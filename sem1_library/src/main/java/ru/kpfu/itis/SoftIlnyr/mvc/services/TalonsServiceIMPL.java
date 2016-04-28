package ru.kpfu.itis.SoftIlnyr.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Talon;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.TalonsRepository;

/**
 * Created by softi on 28.04.2016.
 */
@Service
@Transactional
public class TalonsServiceIMPL implements TalonsService {

    @Autowired
    TalonsRepository talonsRepository;

    public void add(Talon talon) {
        talonsRepository.save(talon);
    }
}
