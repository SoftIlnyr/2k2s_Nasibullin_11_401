package ru.kpfu.itis.Ilnyr_Nasibullin.Models;

import ru.kpfu.itis.Ilnyr_Nasibullin.Repositories.UsersRepository;

import java.sql.SQLException;

/**
 * Created by Ilnyr on 12.11.2015.
 */
public class Comment {
    private int id;
    private int user_id;
    private String username;
    private int book_id;
    private String text;

    public Comment(int id, int user_id, int book_id, String text) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.user_id = user_id;
        this.username = UsersRepository.getUserById(user_id).getName();
        this.book_id = book_id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
