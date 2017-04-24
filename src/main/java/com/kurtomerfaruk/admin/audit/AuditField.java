
package com.kurtomerfaruk.admin.audit;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Omer Faruk KURT
 * @Created on date 18/10/2016 16:25:11 
 */
@Entity
@Table(name = "audit_field")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditField.findAll", query = "SELECT a FROM AuditField a"),
    @NamedQuery(name = "AuditField.findById", query = "SELECT a FROM AuditField a WHERE a.id = :id"),
    @NamedQuery(name = "AuditField.findByFieldName", query = "SELECT a FROM AuditField a WHERE a.fieldName = :fieldName"),
    @NamedQuery(name = "AuditField.findByFieldValue", query = "SELECT a FROM AuditField a WHERE a.fieldValue = :fieldValue"),
    @NamedQuery(name = "AuditField.findByAuditEntryId", query = "SELECT a FROM AuditField a WHERE a.auditEntryId = :auditEntryId")})
public class AuditField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "field_name")
    private String fieldName;
    @Size(max = 5000)
    @Column(name = "field_value")
    private String fieldValue;
    @JoinColumn(name = "audit_entry_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AuditEntry auditEntryId;

    public AuditField() {
    }

    public AuditField(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public AuditEntry getAuditEntryId() {
        return auditEntryId;
    }

    public void setAuditEntryId(AuditEntry auditEntryId) {
        this.auditEntryId = auditEntryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditField)) {
            return false;
        }
        AuditField other = (AuditField) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kurtomerfaruk.admin.audit.AuditField[ id=" + id + " ]";
    }

}
