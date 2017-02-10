package xyz.codingmentor.jpaonweb.ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author blazefury
 */
@Entity
public class Film implements Serializable {

    @Id @GeneratedValue
    private int filmId;
    private String title;
    @ManyToMany(mappedBy = "films", cascade = CascadeType.PERSIST)
    private List<Actor> actors;
    @OneToMany(mappedBy = "film", cascade = CascadeType.PERSIST)
    private List<Trailer> trailers;
    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    public Film() {
        //empty on purpose
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
