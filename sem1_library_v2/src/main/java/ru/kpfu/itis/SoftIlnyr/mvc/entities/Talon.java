package ru.kpfu.itis.SoftIlnyr.mvc.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by softi on 18.04.2016.
 */
@Entity
@Table(name = "book_tickets", schema = "public", catalog = "legistis_libro")
public class Talon {
    private int id;
    private int period;
    private String status;
        @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Book book;
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Library library;
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "talon_id_secuence")
    @SequenceGenerator(name = "talon_id_secuence", sequenceName = "book_tickets_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "period")
    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne(targetEntity = Library.class)
    @JoinColumn(name = "library_id")
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Talon that = (Talon) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + period;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
