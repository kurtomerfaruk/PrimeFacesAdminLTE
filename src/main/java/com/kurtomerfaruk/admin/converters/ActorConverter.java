package com.kurtomerfaruk.admin.converters;

import com.kurtomerfaruk.admin.dao.IActorDAO;
import com.kurtomerfaruk.admin.dao.impl.ActorDAOImpl;
import com.kurtomerfaruk.admin.models.Actor;
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
@FacesConverter(value = "actorConverter")
public class ActorConverter implements Converter {

    private final IActorDAO dao=new ActorDAOImpl();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.dao.read(getKey(value));
    }

    java.lang.Short getKey(String value) {
        java.lang.Short key;
        key = Short.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Short value) {
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
        if (object instanceof Actor) {
            Actor o = (Actor) object;
            return getStringKey(o.getActorId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Actor.class.getName()});
            return null;
        }
    }

}
