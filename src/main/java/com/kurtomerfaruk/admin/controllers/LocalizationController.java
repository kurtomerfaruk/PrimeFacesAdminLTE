package com.kurtomerfaruk.admin.controllers;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Omer Faruk Kurt
 * @blog http://kurtomerfaruk.com
 * @mail kurtomerfaruk@gmail.com
 * @Created on date 14/04/2017 09:22:36
 */
@ManagedBean
@SessionScoped
public class LocalizationController implements java.io.Serializable {

    private static final long serialVersionUID = -8649833177588458792L;

    private Locale locale;

    public LocalizationController() {

    }

    @PostConstruct
    public void init() {
        locale = new Locale("en");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    public void changeLocale(String code) {
        Locale l = new Locale(code);
        if (locale != null) {
            if (!locale.equals(l)) {
                locale = l;
                FacesContext.getCurrentInstance().getViewRoot().setLocale(l);
            }
        }
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
