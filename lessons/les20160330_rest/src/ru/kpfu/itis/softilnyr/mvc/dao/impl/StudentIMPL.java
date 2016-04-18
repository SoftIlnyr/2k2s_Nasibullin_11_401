package ru.kpfu.itis.softilnyr.mvc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.kpfu.itis.softilnyr.mvc.dao.MyConnection;
import ru.kpfu.itis.softilnyr.mvc.models.Student;
import ru.kpfu.itis.softilnyr.mvc.dao.StudentDAO;

import javax.activation.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by softi on 30.03.2016.
 */
public class StudentIMPL implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) ds);
    }

    @Override
    public void create(int id, String name) {
        try {
            PreparedStatement statement = MyConnection.getConnection().prepareStatement("INSERT into students values (?, ?)");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student getStudent(int id) {
        try {
            PreparedStatement statement = MyConnection.getConnection().prepareStatement("SELECT * FROM students WHERE id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            Student student = new Student();
            while (set.next()) {
                student.setId((int) set.getObject(1));
                student.setName((String) set.getObject(2));
            }
            return student;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> allStudents() {
        try {
            PreparedStatement statement = MyConnection.getConnection().prepareStatement("select * from students");
            ResultSet set = statement.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while (set.next()) {
                students.add(new Student((int) set.getObject(1), (String) set.getObject(2)));
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = MyConnection.getConnection().prepareStatement("DELETE * from students where id=?");
            statement.setInt(1, id);
            statement.executeQuery();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String name) {
        PreparedStatement statement = null;
        try {
            statement = MyConnection.getConnection().prepareStatement("UPDATE TABLE students " +
                    "SET (name=?) " +
                    "WHERE id=?");
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
