package ru.kpfu.itis.SoftIlnyr.mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

/**
 * Created by softi on 02.05.2016.
 */
//@Component
public class MyUserDetailesService implements UserDetailsService {

    @Autowired
    UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = usersService.findByNickname(s);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + s + " no found");
        }
        return new MyUserDetailes(user);
    }
}
