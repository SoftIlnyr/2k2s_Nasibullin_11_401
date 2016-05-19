package ru.kpfu.itis.SoftIlnyr.mvc.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 18.04.2016.
 */
@Entity
@Table(name = "libraries", schema = "public", catalog = "legistis_libro")
public class Library{
    private int id;
    private String address;
    private String name;
    @JsonIgnore
    private List<Presence> presence;
    @JsonIgnore
    private List<Talon> talons;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_id_secuence")
    @SequenceGenerator(name = "library_id_secuence", sequenceName = "libraries_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(targetEntity = Presence.class, mappedBy = "library", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Presence> getPresence() {
        return presence;
    }

    public void setPresence(List<Presence> presence) {
        this.presence = presence;
    }

    @OneToMany(targetEntity = Talon.class, mappedBy = "library", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

        Library library = (Library) o;

        if (id != library.id) return false;
        if (address != null ? !address.equals(library.address) : library.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
