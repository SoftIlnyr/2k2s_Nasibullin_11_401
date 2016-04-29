package ru.kpfu.itis.SoftIlnyr.mvc.services;

import ru.kpfu.itis.SoftIlnyr.mvc.entities.Library;

import java.util.List;

/**
 * Created by softi on 25.04.2016.
 */
public interface LibrariesService {
    void addLibrary(Library library);

    List<Library> findAll();

    Library findById(int id);
}
