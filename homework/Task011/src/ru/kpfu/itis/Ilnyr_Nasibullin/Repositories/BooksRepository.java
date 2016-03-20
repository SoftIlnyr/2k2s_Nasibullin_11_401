package ru.kpfu.itis.Ilnyr_Nasibullin.Repositories;

import org.json.JSONArray;
import ru.kpfu.itis.Ilnyr_Nasibullin.Models.Book;
import ru.kpfu.itis.Ilnyr_Nasibullin.Models.Comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ilnyr on 17.10.2015.
 */
public class BooksRepository {
    public static ArrayList<Book> getBooks() throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT * from book_info");
        ResultSet set = statement.executeQuery();
        ArrayList<Book> books = new ArrayList<>();
        while (set.next()) {
            Book book = new Book((Integer) set.getObject(1), (String) set.getObject(2), (String) set.getObject(3), (Integer) set.getObject(4),
                    (String) set.getObject(5), (String) set.getObject(6));
            books.add(book);
        }
        return books;
    }

    public static HashMap<String, Object> getBookById1(int book_id) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT * from book_info WHERE id=?");
        statement.setInt(1, book_id);
        ResultSet set = statement.executeQuery();
        ResultSetMetaData data = set.getMetaData();
        int columns = data.getColumnCount();
        HashMap<String, Object> row = new HashMap<>(columns);
        if (set.next()) {
            for (int i = 1; i <= columns; i++) {
                row.put(data.getColumnName(i), set.getObject(i));
            }
        }
        return row;
    }

    public static Book getBookById(int book_id) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT * from book_info WHERE id=?");
        statement.setInt(1, book_id);
        ResultSet set = statement.executeQuery();
        Book book = null;
        if (set.next()) {
            book = new Book(book_id, (String) set.getObject(2), (String) set.getObject(3), (Integer) set.getObject(4),
                    (String) set.getObject(5), (String) set.getObject(6));
        }
        return book;
    }

    public static HashMap<String, String> getBookByName(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT * from book_info WHERE name=?");
        statement.setString(1, name);
        ResultSet set = statement.executeQuery();
        ResultSetMetaData data = set.getMetaData();
        int columns = data.getColumnCount();
        HashMap<String, String> row = new HashMap<>(columns);
        if (set.next()) {
            for (int i = 1; i <= columns; i++) {
                row.put(data.getColumnName(i), (String) set.getObject(i));
            }
        }
        return row;
    }

    public static ArrayList<Book> findBooksByName(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT * from book_info " +
                "WHERE name ilike ?");
        statement.setString(1, name + "%");
        ResultSet set = statement.executeQuery();
        ArrayList<Book> books = new ArrayList<>();
        while (set.next()) {
            Book book = new Book((Integer) set.getObject(1), (String) set.getObject(2), (String) set.getObject(3), (Integer) set.getObject(4),
                    (String) set.getObject(5), (String) set.getObject(6));
            books.add(book);
        }
        return books;
    }

    public static JSONArray findBooksByName1(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT name from book_info " +
                "WHERE name ilike ?");
        statement.setString(1, name + "%");
        ResultSet set = statement.executeQuery();
        JSONArray ja = new JSONArray();
        while (set.next()) {
            ja.put(set.getString(1));
        }
        return ja;
    }

    public static int getBookId(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select id from book_info where name=?");
        statement.setString(1, name);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            return set.getInt(1);
        }
        return 0;
    }

    public static void addBook(String bookname, String bookpath, String coverpath, String genre) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("insert into book_info(name, path, cover, genre) " +
                "values(?, ?, ?, ?)");
        statement.setString(1, bookname);
        statement.setString(2, bookpath);
        statement.setString(3, coverpath);
        statement.setString(4, genre);
        statement.executeUpdate();
    }


    public static ArrayList<Book> getWriterBooks(String user) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select book_info.id, book_info.name, " +
                "book_info.genre, book_info.rating, book_info.path, book_info.cover from book_info, writer_books, users " +
                "where book_info.id=writer_books.book_id and users.id=writer_books.user_id and users.name=?");
        statement.setString(1, user);
        ResultSet set = statement.executeQuery();
        ArrayList<Book> books = new ArrayList<>();
        while (set.next()) {
            Book book = new Book((Integer) set.getObject(1), (String) set.getObject(2), (String) set.getObject(3), (Integer) set.getObject(4),
                    (String) set.getObject(5), (String) set.getObject(6));
            books.add(book);
        }
        return books;
    }

    public static void addComment(int book_id, int user_id, String text) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("insert into comments(user_id, book_id, text) values(?, ?, ?)");
        statement.setInt(1, user_id);
        statement.setInt(2, book_id);
        statement.setString(3, text);
        statement.executeUpdate();
    }

    public static ArrayList<Comment> getBookComments(int book_id) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select comments.id, comments.user_id, comments.book_id, " +
                "comments.text from comments, users, book_info where comments.user_id=users.id and comments.book_id=book_info.id and comments.book_id=?");
        statement.setInt(1, book_id);
        ResultSet set = statement.executeQuery();
        ArrayList<Comment> comments = new ArrayList<>();
        while (set.next()) {
            comments.add(new Comment((int) set.getObject(1), (int) set.getObject(2), (int) set.getObject(3), (String) set.getObject(4)));
        }
        return comments;
    }
}
