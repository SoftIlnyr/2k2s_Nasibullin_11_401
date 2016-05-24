package ru.kpfu.itis.SoftIlnyr.mvc.services.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Presence;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.PresenceRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.PresenceService;

import java.util.List;

/**
 * Created by softi on 27.04.2016.
 */
@Service
@Transactional
public class PresenceServiceIMPL implements PresenceService {

    @Autowired
    public PresenceRepository presenceRepository;

    public List<Presence> findAll() {
        List<Presence> presences = (List<Presence>) presenceRepository.findAll();
        return presences;
    }

    public void addPresence(Presence presence) {
        presenceRepository.save(presence);
    }

    public void update(Presence presence) {
        presenceRepository.save(presence);
    }
}
