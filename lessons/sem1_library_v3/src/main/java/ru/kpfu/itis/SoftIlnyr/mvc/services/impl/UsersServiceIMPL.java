package ru.kpfu.itis.SoftIlnyr.mvc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;
import ru.kpfu.itis.SoftIlnyr.mvc.repositories.UsersRepository;
import ru.kpfu.itis.SoftIlnyr.mvc.services.UsersService;

import java.util.List;

/**
 * Created by softi on 23.04.2016.
 */
@Service
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

    public void update(User user) {
        usersRepository.save(user);
    }

    public List<User> findAll() {
        return (List<User>) usersRepository.findAll();
    }
}