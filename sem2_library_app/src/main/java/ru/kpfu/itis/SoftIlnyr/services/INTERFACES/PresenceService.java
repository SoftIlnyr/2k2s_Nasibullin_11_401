package ru.kpfu.itis.SoftIlnyr.services.INTERFACES;

import ru.kpfu.itis.SoftIlnyr.entities.Presence;

import java.util.List;

/**
 * Created by softi on 27.04.2016.
 */
public interface PresenceService {

    List<Presence> findAll();

    void addPresence(Presence presence);

    void update(Presence presence);
}
