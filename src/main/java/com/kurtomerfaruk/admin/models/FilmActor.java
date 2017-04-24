package com.kurtomerfaruk.admin.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@Entity
@Table(name = "film_actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FilmActor.findAll", query = "SELECT f FROM FilmActor f"),
    @NamedQuery(name = "FilmActor.findByActor", query = "SELECT f FROM FilmActor f WHERE f.actor = :actorId"),
    @NamedQuery(name = "FilmActor.findByFilm", query = "SELECT f FROM FilmActor f WHERE f.film = :filmId"),
    @NamedQuery(name = "FilmActor.findByLastUpdate", query = "SELECT f FROM FilmActor f WHERE f.lastUpdate = :lastUpdate")})
public class FilmActor extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "film_actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short filmActorId;
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Film film;
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actor actor;

    public FilmActor() {
    }

    public Short getFilmActorId() {
        return filmActorId;
    }

    public void setFilmActorId(Short filmActorId) {
        this.filmActorId = filmActorId;
    }

    public FilmActor(Short filmActorId) {
        this.filmActorId = filmActorId;
    }

    public FilmActor(Short filmActorId, Film film, Actor actor) {
        this.filmActorId = filmActorId;
        this.film = film;
        this.actor = actor;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmActorId != null ? filmActorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilmActor)) {
            return false;
        }
        FilmActor other = (FilmActor) object;
        if ((this.filmActorId == null && other.filmActorId != null) || (this.filmActorId != null && !this.filmActorId.equals(other.filmActorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kurtomerfaruk.admin.models.FilmActor[ id=" + filmActorId + " ]";
    }

}
