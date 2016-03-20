package ru.kpfu.itis.Ilnyr_Nasibullin.Models;

/**
 * Created by Ilnyr on 01.11.2015.
 */
public class Book {
    private int id;
    private String name = null;
    private String genre = null;
    private int rating;
    private String textpath = null;
    private String coverpath = null;

    public Book() {

    }

    public Book(int id, String name, String genre, int rating, String textpath, String coverpath) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.textpath = textpath;
        this.coverpath = coverpath;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTextpath() {
        return textpath;
    }

    public void setTextpath(String textpath) {
        this.textpath = textpath;
    }

    public String getCoverpath() {
        return coverpath;
    }

    public void setCoverpath(String coverpath) {
        this.coverpath = coverpath;
    }
}
