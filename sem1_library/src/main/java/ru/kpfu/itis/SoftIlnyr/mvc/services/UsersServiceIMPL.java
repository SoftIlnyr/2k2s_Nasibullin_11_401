package ru.kpfu.itis.SoftIlnyr.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.UsersRepository;

/**
 * Created by softi on 23.04.2016.
 */
@Service
@Transactional
public class UsersServiceIMPL implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    public void addUser(User user) {
        usersRepository.save(user);
    }

    public User findById(int id) {
        User user = usersRepository.findOne(id);
        return user;
    }
}
