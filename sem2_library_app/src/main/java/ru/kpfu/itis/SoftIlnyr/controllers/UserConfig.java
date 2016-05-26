package ru.kpfu.itis.SoftIlnyr.controllers;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by softi on 25.05.2016.
 */
@Component
public class UserConfig {
    public String nickname;
    public String password;

    public UserConfig(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public UserConfig() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
