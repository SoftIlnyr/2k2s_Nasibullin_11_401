package ru.kpfu.itis.SoftIlnyr.mvc.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
@Entity
@Table(name = "authors", schema = "public", catalog = "legistis_libro")
public class Author {
    private int id;
    private String name;
    private String photo;
    private String surname;
    private String info;
    private List<Book> books;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_secuence")
    @SequenceGenerator(name = "author_id_secuence", sequenceName = "authors_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @OneToMany(targetEntity = Book.class, mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (name != null ? !name.equals(author.name) : author.name != null) return false;
        if (photo != null ? !photo.equals(author.photo) : author.photo != null) return false;
        if (surname != null ? !surname.equals(author.surname) : author.surname != null) return false;
        if (info != null ? !info.equals(author.info) : author.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }
}
