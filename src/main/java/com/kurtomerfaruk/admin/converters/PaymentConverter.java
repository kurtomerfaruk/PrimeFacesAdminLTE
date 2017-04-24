package com.kurtomerfaruk.admin.converters;

import com.kurtomerfaruk.admin.dao.IPaymentDAO;
import com.kurtomerfaruk.admin.dao.impl.PaymentDAOImpl;
import com.kurtomerfaruk.admin.models.Payment;
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
@FacesConverter(value = "paymentConverter")
public class PaymentConverter implements Converter {

    private final IPaymentDAO dao = new PaymentDAOImpl();

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
        if (object instanceof Payment) {
            Payment o = (Payment) object;
            return getStringKey(o.getPaymentId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Payment.class.getName()});
            return null;
        }
    }

}
