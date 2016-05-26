package ru.kpfu.itis.SoftIlnyr.controllers;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

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

    public HttpHeaders createHeaders() {
        return new HttpHeaders() {
            {
                String auth = nickname + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }
}
