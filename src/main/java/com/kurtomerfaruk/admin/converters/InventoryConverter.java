package com.kurtomerfaruk.admin.converters;

import com.kurtomerfaruk.admin.dao.IInventoryDAO;
import com.kurtomerfaruk.admin.dao.impl.InventoryDAOImpl;
import com.kurtomerfaruk.admin.models.Inventory;
import com.kurtomerfaruk.admin.utils.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@FacesConverter(value = "inventoryConverter")
public class InventoryConverter implements Converter {

    private final IInventoryDAO dao = new InventoryDAOImpl();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.dao.read(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Inventory) {
            Inventory o = (Inventory) object;
            return getStringKey(o.getInventoryId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Inventory.class.getName()});
            return null;
        }
    }

}
