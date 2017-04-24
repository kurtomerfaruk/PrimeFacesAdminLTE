package com.kurtomerfaruk.admin.models;

import com.kurtomerfaruk.admin.audit.AuditListener;
import com.kurtomerfaruk.admin.audit.CityAuditListener;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@Entity
@Table(name = "city")
@EntityListeners({AuditListener.class})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findByCityId", query = "SELECT c FROM City c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "City.findByCity", query = "SELECT c FROM City c WHERE c.city = :city"),
    @NamedQuery(name = "City.findByLastUpdate", query = "SELECT c FROM City c WHERE c.lastUpdate = :lastUpdate")})
public class City extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_id")
    private Short cityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = false)
    private Country countryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private List<Address> addressList;

    public City() {
    }

    public City(Short cityId) {
        this.cityId = cityId;
    }

    public City(Short cityId, String city) {
        this.cityId = cityId;
        this.city = city;
    }

    public Short getCityId() {
        return cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kurtomerfaruk.admin.models.City[ cityId=" + cityId + " ]";
    }

}
