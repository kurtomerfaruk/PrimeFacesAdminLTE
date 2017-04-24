package com.kurtomerfaruk.admin.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "rental")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rental.findAll", query = "SELECT r FROM Rental r"),
    @NamedQuery(name = "Rental.findByRentalId", query = "SELECT r FROM Rental r WHERE r.rentalId = :rentalId"),
    @NamedQuery(name = "Rental.findByRentalDate", query = "SELECT r FROM Rental r WHERE r.rentalDate = :rentalDate"),
    @NamedQuery(name = "Rental.findByReturnDate", query = "SELECT r FROM Rental r WHERE r.returnDate = :returnDate"),
    @NamedQuery(name = "Rental.findByLastUpdate", query = "SELECT r FROM Rental r WHERE r.lastUpdate = :lastUpdate")})
public class Rental extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rental_id")
    private Integer rentalId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rental_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalDate;
    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @OneToMany(mappedBy = "rentalId")
    private List<Payment> paymentList;
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false)
    private Staff staffId;
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    @ManyToOne(optional = false)
    private Inventory inventoryId;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customerId;

    public Rental() {
    }

    public Rental(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Rental(Integer rentalId, Date rentalDate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Inventory getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Inventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentalId != null ? rentalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rental)) {
            return false;
        }
        Rental other = (Rental) object;
        if ((this.rentalId == null && other.rentalId != null) || (this.rentalId != null && !this.rentalId.equals(other.rentalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kurtomerfaruk.admin.models.Rental[ rentalId=" + rentalId + " ]";
    }
    
}
