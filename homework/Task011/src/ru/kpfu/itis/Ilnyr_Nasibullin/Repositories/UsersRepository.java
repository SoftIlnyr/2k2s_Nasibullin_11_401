package ru.kpfu.itis.Ilnyr_Nasibullin.Repositories;

import ru.kpfu.itis.Ilnyr_Nasibullin.Aspects.MyConnection;
import ru.kpfu.itis.Ilnyr_Nasibullin.Models.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ilnyr on 17.10.2015.
 */
public class UsersRepository {
    public static ArrayList<User> getWriterNames() throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select users.id, users.name, users.email from users, writer_info " +
                "where users.id=writer_info.user_id");
        ResultSet set = statement.executeQuery();
        ArrayList<User> writers = new ArrayList<>();
        while (set.next()) {
            writers.add(new User((int) set.getObject(1), (String) set.getObject(2), (String) set.getObject(3)));
        }
        return writers;
    }

    public static ArrayList<User> findWritersByName(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select users.id, users.name, users.email from users, writer_info " +
                "where users.id=writer_info.user_id and users.name ilike ?");
        statement.setString(1, name + "%");
        ResultSet set = statement.executeQuery();
        ArrayList<User> writers = new ArrayList<>();
        while (set.next()) {
            writers.add(new User((int) set.getObject(1), (String) set.getObject(2), (String) set.getObject(3)));
        }
        return writers;
    }

    public static ArrayList<User> getCriticNames() throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select users.id, users.name, users.email from users, critic_info " +
                "where users.id=critic_info.user_id");
        ResultSet set = statement.executeQuery();
        ArrayList<User> critics = new ArrayList<>();
        while (set.next()) {
            critics.add(new User((int) set.getObject(1), (String) set.getObject(2), (String) set.getObject(3)));
        }
        return critics;
    }

    public static ArrayList<User> findCriticsByName(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select users.id, users.name, users.email from users, critic_info " +
                "where users.id=critic_info.user_id and users.name ilike ?");
        statement.setString(1, name + "%");
        ResultSet set = statement.executeQuery();
        ArrayList<User> critics = new ArrayList<>();
        while (set.next()) {
            critics.add(new User((int) set.getObject(1), (String) set.getObject(2), (String) set.getObject(3)));
        }
        return critics;
    }

    public static User getUserByName(String user) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT id, name, email, password FROM users WHERE name ilike ?");
        statement.setString(1, user);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            return new User((int) set.getObject(1), (String) set.getObject(2), (String) set.getObject(3), (String) set.getObject(4));
        }
        return null;
    }

    public static ArrayList<HashMap<String, String>> getUserByName1(String user) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT name, password FROM users WHERE name=?");
        statement.setString(1, user);
        ResultSet set = statement.executeQuery();
        ResultSetMetaData data = set.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        int colums = data.getColumnCount();
        while (set.next()) {
            HashMap row = new HashMap(colums);
            row.put("user", set.getString(1));
            row.put("password", set.getString(2));
            table.add(row);
        }
        return table;
    }

    public static ArrayList<HashMap<String, String>> getUserByEmail(String email) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT name, password FROM users WHERE email=?");
        statement.setString(1, email);
        ResultSet set = statement.executeQuery();
        ResultSetMetaData data = set.getMetaData();
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        int colums = data.getColumnCount();
        while (set.next()) {
            HashMap row = new HashMap(colums);
            row.put("user", set.getString(1));
            row.put("password", set.getString(2));
            table.add(row);
        }
        return table;
    }

    public static void addUser(String email, String user, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("insert into users(email, name, password) VALUES " +
                "(?, ?, ?)");
        statement.setString(1, email);
        statement.setString(2, user);
        statement.setString(3, password);
        statement.executeUpdate();
    }

    public static void addWriter(String user) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select id from users where name=?");
        statement.setString(1, user);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            PreparedStatement statement1 = MyConnection.getConnection().prepareStatement("insert into writer_info(user_id) VALUES " +
                    "(?)");
            statement1.setInt(1, set.getInt(1));
            statement1.executeUpdate();
        }
    }

    public static void addCritic(String user) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select id from users where name=?");
        statement.setString(1, user);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            PreparedStatement statement1 = MyConnection.getConnection().prepareStatement("insert into critic_info(user_id) VALUES " +
                    "(?)");
            statement1.setInt(1, set.getInt(1));
            statement1.executeUpdate();
        }
    }

    public static boolean isWriter(String user) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select id from users where NAME=? and id in (select user_id from writer_info)");
        statement.setString(1, user);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            return true;
        } else return false;
    }

    public static boolean isCritic(String user) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select id from users where NAME=? and id in (select user_id from critic_info)");
        statement.setString(1, user);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            return true;
        } else return false;
    }

    public static int getUserId(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("select id from users where name=?");
        statement.setString(1, name);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            return set.getInt(1);
        }
        return 0;
    }

    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // ��� ����� ���������� ������
            // ��������� ��� ���� � ������������ �������� � getInstance(,,,) �� ����������
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }

    public static void updateUser(User user) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("UPDATE users set name=?, email=?, password=? where id=?");
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setInt(4, user.getId());
        statement.executeUpdate();
    }

    public static void addBookToWriter(int book_id, int user_id) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("insert into writer_books (user_id, book_id) values (?, ?)");
        statement.setInt(1, user_id);
        statement.setInt(2, book_id);
        statement.executeUpdate();
    }

    public static User getUserById(int user_id) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT id, name, email from users WHERE id=?");
        statement.setInt(1, user_id);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            return new User((int) set.getObject(1), (String) set.getObject(2), (String) set.getObject(3));
        }
        return null;
    }
}
