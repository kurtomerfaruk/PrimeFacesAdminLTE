/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kurtomerfaruk.admin.chart;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class MapClass {

    private String country;
    private String count;

    /**
     *
     * @param country
     * @param count
     */
    public MapClass(String country, String count) {
        this.country = country;
        this.count = count;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public String getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(String count) {
        this.count = count;
    }

}
