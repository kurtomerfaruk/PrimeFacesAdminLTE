package com.kurtomerfaruk.admin.models;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@MappedSuperclass
public class BaseEntity {

    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @PrePersist
    public void onPersist() {
        lastUpdate = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        lastUpdate = new Date();
    }

}
