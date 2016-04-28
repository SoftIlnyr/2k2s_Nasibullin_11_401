package ru.kpfu.itis.SoftIlnyr.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.Presence;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.PresenceRepository;

import java.util.List;

/**
 * Created by softi on 27.04.2016.
 */
@Service
@Transactional
public class PresenceServiceIMPL implements PresenceService {

    @Autowired
    private PresenceRepository presenceRepository;

    public List<Presence> findAll() {
        List<Presence> presences = (List<Presence>) presenceRepository.findAll();
        return presences;
    }

    public void addPresence(Presence presence) {
        presenceRepository.save(presence);
    }
}
