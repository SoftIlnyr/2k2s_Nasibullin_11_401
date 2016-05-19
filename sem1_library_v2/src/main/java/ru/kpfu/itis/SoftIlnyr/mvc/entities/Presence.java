package ru.kpfu.itis.SoftIlnyr.mvc.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by softi on 18.04.2016.
 */
@Entity
@Table(name = "books_libraries", schema = "public", catalog = "legistis_libro")
public class Presence{
    private int amount;
    private Book book;
    @JsonManagedReference
    private Library library;
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_library_id_secuence")
    @SequenceGenerator(name = "books_library_id_secuence", sequenceName = "books_libraries_id_secuence", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne(targetEntity = Library.class)
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Presence that = (Presence) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return amount;
    }
}
