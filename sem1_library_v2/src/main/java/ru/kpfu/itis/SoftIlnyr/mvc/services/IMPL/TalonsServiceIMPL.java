package ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Talon;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.TalonsRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.TalonsService;

import java.util.List;

/**
 * Created by softi on 28.04.2016.
 */
@Service
@Transactional
public class TalonsServiceIMPL implements TalonsService {

    @Autowired
    public TalonsRepository talonsRepository;

    public void add(Talon talon) {
        talonsRepository.save(talon);
    }

    public List<Talon> findAll() {
        return (List<Talon>) talonsRepository.findAll();
    }

    public Talon findById(int talon_id) {
        return talonsRepository.findOne(talon_id);
    }

    public void update(Talon talon) {
        talonsRepository.save(talon);
    }

}
