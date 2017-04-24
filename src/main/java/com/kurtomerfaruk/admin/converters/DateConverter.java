package com.kurtomerfaruk.admin.converters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Omer Faruk KURT
 */
@FacesConverter("dateConverter")
public class DateConverter implements javax.faces.convert.Converter {

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            if (value.equals("__.__.____")) {
                return "";
            }
            if (!value.contains("_") && value.length()==10) {
                calendar.setTime(sdf.parse(value));
            } else {
                return "";
            }

            if (value.length() != 10) {
                return "";
            }
            Timestamp result = new Timestamp(calendar.getTime().getTime());
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(result);
        } catch (ParseException e) {
            throw new UnsupportedOperationException("DateConverter exception"); 
        }

    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

}