package xyz.codingmentor.jpaonweb.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import xyz.codingmentor.jpaonweb.ejb.type.TrailerType;

/**
 *
 * @author blazefury
 */
@Entity
public class Trailer implements Serializable {

    @Id @GeneratedValue
    private int trailerId;
    private String url;
    @Enumerated(EnumType.STRING)
    private TrailerType type;
    private String title;
    @Temporal(TemporalType.DATE)
    private Date dateOfRelease;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Film film;

    public Trailer() {
        //empty on purpose
    }

    public int getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(int trailerId) {
        this.trailerId = trailerId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TrailerType getType() {
        return type;
    }

    public void setType(TrailerType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

}
