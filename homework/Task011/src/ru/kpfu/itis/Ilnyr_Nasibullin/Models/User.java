package ru.kpfu.itis.Ilnyr_Nasibullin.Models;

import java.sql.SQLException;

/**
 * Created by Ilnyr on 01.11.2015.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    public User(int id, String name, String email) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(int id, String name, String email, String password) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
