package com.kurtomerfaruk.admin.controllers;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Omer Faruk KURT 
 * @Created on date 14/07/2016 21:26:57 
 */
@ManagedBean
@ApplicationScoped
public class ExporterController implements Serializable {

	private static final long serialVersionUID = 20120316L;

	private Boolean customExporter;


	public ExporterController() {
             customExporter=false;
	}

    public Boolean getCustomExporter() {
        return customExporter;
    }

    public void setCustomExporter(Boolean customExporter) {
        this.customExporter = customExporter;
    }
}
