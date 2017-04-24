package com.kurtomerfaruk.admin.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findById", query = "SELECT m FROM Menu m WHERE m.id = :id"),
    @NamedQuery(name = "Menu.findByMenuName", query = "SELECT m FROM Menu m WHERE m.menuName = :menuName"),
    @NamedQuery(name = "Menu.findByName", query = "SELECT m FROM Menu m WHERE m.menuName LIKE :menuName"),
    @NamedQuery(name = "Menu.findByMenuLink", query = "SELECT m FROM Menu m WHERE m.menuLink = :menuLink"),
    @NamedQuery(name = "Menu.findByIcon", query = "SELECT m FROM Menu m WHERE m.icon = :icon")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "top_menu_id")
    private Integer topMenuId;
    @Column(name = "menu_type")
    private Integer menuType;
    @Size(max = 45)
    @Column(name = "menu_link")
    private String menuLink;
    @Size(max = 45)
    @Column(name = "icon")
    private String icon;
    @Column(name = "icon_color")
    private String iconColor;
    @Column(name = "queue")
    private Integer queue;

    public Menu() {
    }

    public Menu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getTopMenuId() {
        return topMenuId;
    }

    public void setTopMenuId(Integer topMenuId) {
        this.topMenuId = topMenuId;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kurtomerfaruk.admin.models.Menu[ id=" + id + " ]";
    }

}
