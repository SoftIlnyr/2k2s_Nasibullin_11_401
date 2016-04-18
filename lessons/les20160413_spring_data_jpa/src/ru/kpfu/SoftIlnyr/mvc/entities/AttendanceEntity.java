package ru.kpfu.SoftIlnyr.mvc.entities;

import javax.persistence.*;

/**
 * Created by softi on 08.04.2016.
 */
@Entity
@Table(name = "attendance", schema = "public", catalog = "virtual_schools")
public class AttendanceEntity {
    private int classId;
    private int teacherId;
    private int year;
    private int studentId;
    private int id;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "class_id")
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "teacher_id")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceEntity that = (AttendanceEntity) o;

        if (classId != that.classId) return false;
        if (teacherId != that.teacherId) return false;
        if (year != that.year) return false;
        if (studentId != that.studentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId;
        result = 31 * result + teacherId;
        result = 31 * result + year;
        result = 31 * result + studentId;
        return result;
    }
}
