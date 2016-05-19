package ru.kpfu.itis.SoftIlnyr.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "legistis_libro")
public class User{
    private int id;
    private String nickname;
    private String password;
    private String firstName;
    private String lastName;
    private String surname;
    private int rating;
    private String avatar;
    private String email;
    private String role;
    private List<Talon> talons;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_secuence")
    @SequenceGenerator(name = "user_id_secuence", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(targetEntity = Talon.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Talon> getTalons() {
        return talons;
    }

    public void setTalons(List<Talon> talons) {
        this.talons = talons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (rating != user.rating) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (avatar != null ? !avatar.equals(user.avatar) : user.avatar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
