package xyz.codingmentor.jpaonweb.ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author blazefury
 */
@Entity
public class Actor implements Serializable {

    @Id @GeneratedValue
    private int actorId;
    private String firstName;
    private String lastName;
    private String nationality;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "jnd_actor_movie",
            joinColumns = @JoinColumn(name = "film_fk"),
            inverseJoinColumns = @JoinColumn(name = "actor_fk"))
    private List<Film> films;

    public Actor() {
        //empty on purpose
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

}
