package ru.kpfu.SoftIlnyr.entities;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by softi on 08.04.2016.
 */
@Entity
@Table(name = "subjects", schema = "public", catalog = "virtual_schools")
public class SubjectsEntity {
    private int id;
    private String title;
    private int teacherId;
    private TeachersEntity teacherEn;
    private int maxS;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "max_s")
    public int getMaxS() {
        return maxS;
    }

    public void setMaxS(int maxS) {
        this.maxS = maxS;
    }


    @ManyToOne
    public TeachersEntity getTeacherEn() {
        return teacherEn;
    }

    public void setTeacherEn(TeachersEntity teacherEn) {
        this.teacherEn = teacherEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectsEntity that = (SubjectsEntity) o;

        if (id != that.id) return false;
        if (teacherId != that.teacherId) return false;
        if (maxS != that.maxS) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + teacherId;
        result = 31 * result + maxS;
        return result;
    }
}
