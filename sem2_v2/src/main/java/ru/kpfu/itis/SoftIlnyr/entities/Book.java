package ru.kpfu.itis.SoftIlnyr.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
public class Book {
    private int id;
    private String title;
    private String edition;
    private int issue;
    private String language;
    private int rating;
    private String image;
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Author author;
    private String info;
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private List<Presence> presence;
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private List<Talon> talons;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Presence> getPresence() {
        return presence;
    }

    public void setPresence(List<Presence> presence) {
        this.presence = presence;
    }

    public List<Talon> getTalons() {
        return talons;
    }

    public void setTalons(List<Talon> talons) {
        this.talons = talons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (issue != book.issue) return false;
        if (rating != book.rating) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (edition != null ? !edition.equals(book.edition) : book.edition != null) return false;
        if (language != null ? !language.equals(book.language) : book.language != null) return false;
        if (image != null ? !image.equals(book.image) : book.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (edition != null ? edition.hashCode() : 0);
        result = 31 * result + issue;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
