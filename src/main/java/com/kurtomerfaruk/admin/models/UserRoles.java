/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kurtomerfaruk.admin.models;

import com.kurtomerfaruk.admin.enums.ERole;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 * @author Omer Faruk KURT
 * @Created on date 30/11/2016 13:33:10 
 */
@Entity
@Table(name = "user_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRoles.findAll", query = "SELECT u FROM UserRoles u"),
    @NamedQuery(name = "UserRoles.findByStaffId", query = "SELECT u FROM UserRoles u WHERE u.staffId = :staffId"),
    @NamedQuery(name = "UserRoles.findByRole", query = "SELECT u FROM UserRoles u WHERE u.role = :role"),
    @NamedQuery(name = "UserRoles.findByUserRolesId", query = "SELECT u FROM UserRoles u WHERE u.userRolesId = :userRolesId")})
public class UserRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false)
    private Staff staffId;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ERole role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_roles_id")
    private Integer userRolesId;

    public UserRoles() {
    }

    public UserRoles(Integer userRolesId) {
        this.userRolesId = userRolesId;
    }

    public UserRoles(Integer userRolesId, Staff staffId, ERole role) {
        this.userRolesId = userRolesId;
        this.staffId = staffId;
        this.role = role;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public Integer getUserRolesId() {
        return userRolesId;
    }

    public void setUserRolesId(Integer userRolesId) {
        this.userRolesId = userRolesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRolesId != null ? userRolesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoles)) {
            return false;
        }
        UserRoles other = (UserRoles) object;
        if ((this.userRolesId == null && other.userRolesId != null) || (this.userRolesId != null && !this.userRolesId.equals(other.userRolesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kurtomerfaruk.admin.models.UserRoles[ userRolesId=" + userRolesId + " ]";
    }

}
