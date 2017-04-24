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
@Table(name = "film_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FilmCategory.findAll", query = "SELECT f FROM FilmCategory f"),
    @NamedQuery(name = "FilmCategory.findByFilmId", query = "SELECT f FROM FilmCategory f WHERE f.film = :filmId"),
    @NamedQuery(name = "FilmCategory.findByCategoryId", query = "SELECT f FROM FilmCategory f WHERE f.filmCategoryId = :categoryId"),
    @NamedQuery(name = "FilmCategory.findByLastUpdate", query = "SELECT f FROM FilmCategory f WHERE f.lastUpdate = :lastUpdate")})
public class FilmCategory extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_category_id")
    private Short filmCategoryId;
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Film film;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Category category;

    public FilmCategory() {
    }

    public Short getFilmCategoryId() {
        return filmCategoryId;
    }

    public void setFilmCategoryId(Short filmCategoryId) {
        this.filmCategoryId = filmCategoryId;
    }

    public FilmCategory(Short filmCategoryId) {
        this.filmCategoryId = filmCategoryId;
    }

    public FilmCategory(Short filmCategoryId, Film film, Category category) {
        this.filmCategoryId = filmCategoryId;
        this.film = film;
        this.category = category;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmCategoryId != null ? filmCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilmCategory)) {
            return false;
        }
        FilmCategory other = (FilmCategory) object;
        if ((this.filmCategoryId == null && other.filmCategoryId != null) || (this.filmCategoryId != null && !this.filmCategoryId.equals(other.filmCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kurtomerfaruk.admin.models.FilmCategory[ id=" + filmCategoryId + " ]";
    }

}
