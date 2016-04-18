package ru.kpfu.itis.softilnyr.mvc.dao;

import ru.kpfu.itis.softilnyr.mvc.models.Student;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by softi on 30.03.2016.
 */
public interface StudentDAO {
    public void setDataSource(DataSource ds);

    public void create(int id, String name);

    public Student getStudent(int id);

    public List<Student> allStudents();

    public void delete(int id);

    public void update(int id, String name);

}
