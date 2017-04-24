package com.kurtomerfaruk.admin.models;

/**
 *
 * author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class ColumnModel {

    private String header;
    private String property;
    private boolean date;
    private boolean manyToOne;
    private String manyToOneColumn;

    public ColumnModel(String header, String property, boolean date, boolean manyToOne) {
        this.header = header;
        this.property = property;
        this.date = date;
        this.manyToOne = manyToOne;
    }

    public ColumnModel(String header, String property, boolean date, boolean manyToOne, String manyToOneColumn) {
        this.header = header;
        this.property = property;
        this.date = date;
        this.manyToOne = manyToOne;
        this.manyToOneColumn = manyToOneColumn;
    }
    
    

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public boolean isDate() {
        return date;
    }

    public void setDate(boolean date) {
        this.date = date;
    }

    public boolean isManyToOne() {
        return manyToOne;
    }

    public void setManyToOne(boolean manyToOne) {
        this.manyToOne = manyToOne;
    }

    public String getManyToOneColumn() {
        System.out.println("result:"+manyToOneColumn);
        return manyToOneColumn;
    }

    public void setManyToOneColumn(String manyToOneColumn) {
        this.manyToOneColumn = manyToOneColumn;
    }

}
