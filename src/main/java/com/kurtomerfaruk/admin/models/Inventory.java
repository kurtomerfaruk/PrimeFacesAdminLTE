package com.kurtomerfaruk.admin.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findByInventoryId", query = "SELECT i FROM Inventory i WHERE i.inventoryId = :inventoryId"),
    @NamedQuery(name = "Inventory.findByLastUpdate", query = "SELECT i FROM Inventory i WHERE i.lastUpdate = :lastUpdate")})
public class Inventory extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventory_id")
    private Integer inventoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryId")
    private List<Rental> rentalList;
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne(optional = false)
    private Store storeId;
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    @ManyToOne(optional = false)
    private Film filmId;

    public Inventory() {
    }

    public Inventory(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    @XmlTransient
    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryId != null ? inventoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.inventoryId == null && other.inventoryId != null) || (this.inventoryId != null && !this.inventoryId.equals(other.inventoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kurtomerfaruk.admin.models.Inventory[ inventoryId=" + inventoryId + " ]";
    }

}
