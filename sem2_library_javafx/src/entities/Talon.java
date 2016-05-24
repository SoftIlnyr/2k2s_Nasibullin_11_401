package entities;

/**
 * Created by softi on 18.04.2016.
 */
public class Talon {
    private int id;
    private int period;
    private String status;
    private Book book;
    private Library library;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

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
