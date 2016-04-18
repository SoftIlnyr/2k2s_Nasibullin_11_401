package ru.kpfu.itis.SoftIlnyr.mvc.entities;

import javax.persistence.*;

/**
 * Created by softi on 18.04.2016.
 */
@Entity
@Table(name = "books")
public class Book {
    private int id;
    private String title;
    private String edition;
    private int issue;
    private String language;
    private int rating;
    private String image;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "edition")
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Basic
    @Column(name = "issue")
    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
