package ru.kpfu.itis.SoftIlnyr.mvc.entities;

import javax.persistence.*;

/**
 * Created by softi on 18.04.2016.
 */
@Entity
@Table(name = "books_libraries", schema = "public", catalog = "legistis_libro")
public class BooksLibrary {
    private int amount;

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksLibrary that = (BooksLibrary) o;

        if (amount != that.amount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return amount;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
