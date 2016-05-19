package ru.kpfu.itis.SoftIlnyr.services.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.entities.Library;
import ru.kpfu.itis.SoftIlnyr.repositories.LibrariesRepository;
import ru.kpfu.itis.SoftIlnyr.services.INTERFACES.LibrariesService;

import java.util.List;

/**
 * Created by softi on 25.04.2016.
 */
@Service
@Transactional
public class LibrariesServiceIMPL implements LibrariesService {

    @Autowired
    LibrariesRepository librariesRepository;

    public void addLibrary(Library library) {
        librariesRepository.save(library);
    }

    public List<Library> findAll() {
        List<Library> libraries = (List<Library>) librariesRepository.findAll();
        return libraries;
    }

    public Library findById(int id) {
        Library library = librariesRepository.findOne(id);
        return library;
    }
}