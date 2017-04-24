package com.kurtomerfaruk.admin.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@Entity
@Table(name = "column_settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColumnSettings.findAll", query = "SELECT c FROM ColumnSettings c"),
    @NamedQuery(name = "ColumnSettings.findByColumnSettingsId", query = "SELECT c FROM ColumnSettings c WHERE c.columnSettingsId = :columnSettingsId"),
    @NamedQuery(name = "ColumnSettings.findByColumnName", query = "SELECT c FROM ColumnSettings c WHERE c.columnName = :columnName"),
    @NamedQuery(name = "ColumnSettings.findByTableName", query = "SELECT c FROM ColumnSettings c WHERE c.tableName= :tableName ORDER BY c.columnQueue"),
    @NamedQuery(name = "ColumnSettings.findByVisible", query = "SELECT c FROM ColumnSettings c WHERE c.visible = :visible"),
    @NamedQuery(name = "ColumnSettings.findByColumnQueue", query = "SELECT c FROM ColumnSettings c WHERE c.columnQueue = :columnQueue"),
    @NamedQuery(name = "ColumnSettings.findByLastUpdate", query = "SELECT c FROM ColumnSettings c WHERE c.lastUpdate = :lastUpdate")})
public class ColumnSettings extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "column_settings_id")
    private Short columnSettingsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "table_name")
    private String tableName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "column_name")
    private String columnName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visible")
    private boolean visible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "column_queue")
    private short columnQueue;
    @NotNull
    @Column(name = "width")
    private Integer width;

    public ColumnSettings() {
    }

    public ColumnSettings(Short columnSettingsId) {
        this.columnSettingsId = columnSettingsId;
    }

    public ColumnSettings(Short columnSettingsId, String columnName, boolean visible, short columnQueue) {
        this.columnSettingsId = columnSettingsId;
        this.columnName = columnName;
        this.visible = visible;
        this.columnQueue = columnQueue;
    }

    public Short getColumnSettingsId() {
        return columnSettingsId;
    }

    public void setColumnSettingsId(Short columnSettingsId) {
        this.columnSettingsId = columnSettingsId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public short getColumnQueue() {
        return columnQueue;
    }

    public void setColumnQueue(short columnQueue) {
        this.columnQueue = columnQueue;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (columnSettingsId != null ? columnSettingsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColumnSettings)) {
            return false;
        }
        ColumnSettings other = (ColumnSettings) object;
        if ((this.columnSettingsId == null && other.columnSettingsId != null) || (this.columnSettingsId != null && !this.columnSettingsId.equals(other.columnSettingsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kurtomerfaruk.mavenproject1.ColumnSettings[ columnSettingsId=" + columnSettingsId + " ]";
    }

}
