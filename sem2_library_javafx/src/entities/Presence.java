package entities;


/**
 * Created by softi on 18.04.2016.
 */
public class Presence{
    private int amount;
    private Book book;
    private Library library;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

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
