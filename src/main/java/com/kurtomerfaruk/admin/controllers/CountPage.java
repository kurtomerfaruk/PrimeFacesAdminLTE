package com.kurtomerfaruk.admin.controllers;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@ManagedBean
@ViewScoped
public final class CountPage implements java.io.Serializable {

    private static final long serialVersionUID = 7466250594126927225L;

    private int actorCount;
    private int addressCount;
    private int categoryCount;
    private int cityCount;
    private int countryCount;
    private int customerCount;
    private int filmActorCount;
    private int filmCategoryCount;
    private int filmCount;
    private int filmTextCount;
    private int inventoryCount;
    private int languageCount;
    private int paymentCount;
    private int rentalCount;
    private int staffCount;
    private int storeCount;

    private final static List<String> NOT_COLUMN_NAME_LIST = Arrays.asList("BaseEntity",
            "ColumnModel",
            "ColumnSettings",
            "Menu",
            "chart",
            "Language",
            "lang",
            "audit",
            "UserRoles");
    private List<Integer> listCount;

    /**
     *
     */
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ADMIN_PU");

    /**
     *
     */
    protected EntityManager entityManager;

    /**
     *
     */
    public CountPage() {

    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        entityManager = emf.createEntityManager();
        List<String> classList = getClassesInPackage();

        listCount = new ArrayList<>();

        for (int i = 0; i < classList.size(); i++) {
            String tableName = classList.get(i);
           
            if (!NOT_COLUMN_NAME_LIST.contains(tableName)) {
                try {
                   
                    Field field = getClass().getDeclaredField(tableName.substring(0, 1).toLowerCase(new Locale("en_US")) + tableName.substring(1) + "Count");
                    if (field.getName().contains("Count")) {
                        field.setInt(this, entityManager.createQuery("SELECT c FROM " + tableName + " c").getResultList().size());
                    }
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(CountPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     *
     * @param menuLink
     * @return
     */
    public int fieldGetValue(String menuLink) {
        String[] parts = menuLink.split("/");
        int result = 0;
        Field field = null;

        if (!parts[1].equals("menu")) {
            if (!NOT_COLUMN_NAME_LIST.contains(parts[1])) {
                try {
                    field = getClass().getDeclaredField(parts[1] + "Count");
                    result = (int) field.get(this);
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(CountPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }

    private List<String> getClassesInPackage() {
        List<String> classes = new ArrayList<String>();
        String packageNameSlashed = "/" + "com.kurtomerfaruk.admin.models".replace(".", "/");
        URL directoryURL = Thread.currentThread().getContextClassLoader().getResource(packageNameSlashed);
        if (directoryURL == null) {
            return classes;
        }

        String directoryString = directoryURL.getFile();
        if (directoryString == null) {
            return classes;
        }

        File directory = new File(directoryString);
        if (directory.exists()) {
            String[] files = directory.list();
            for (String fileName : files) {
                if (fileName.endsWith(".class")) {
                    fileName = fileName.substring(0, fileName.length() - 6);
                    try {
                        if (!fileName.contains("_")) {
                            classes.add(fileName);
                        }

                    } catch (Exception e) {
                    }
                }
            }
        } else {
        }
        return classes;
    }

    /**
     *
     * @return
     */
    public int getActorCount() {
        return actorCount;
    }

    /**
     *
     * @return
     */
    public int getAddressCount() {
        return addressCount;
    }

    /**
     *
     * @return
     */
    public int getCategoryCount() {
        return categoryCount;
    }

    /**
     *
     * @return
     */
    public int getCityCount() {
        return cityCount;
    }

    /**
     *
     * @return
     */
    public int getCountryCount() {
        return countryCount;
    }

    /**
     *
     * @return
     */
    public int getCustomerCount() {
        return customerCount;
    }

    /**
     *
     * @return
     */
    public int getFilmActorCount() {
        return filmActorCount;
    }

    /**
     *
     * @return
     */
    public int getFilmCategoryCount() {
        return filmCategoryCount;
    }

    /**
     *
     * @return
     */
    public int getFilmCount() {
        return filmCount;
    }

    /**
     *
     * @return
     */
    public int getFilmTextCount() {
        return filmTextCount;
    }

    /**
     *
     * @return
     */
    public int getInventoryCount() {
        return inventoryCount;
    }

    /**
     *
     * @return
     */
    public int getLanguageCount() {
        return languageCount;
    }

    /**
     *
     * @return
     */
    public int getPaymentCount() {
        return paymentCount;
    }

    /**
     *
     * @return
     */
    public int getRentalCount() {
        return rentalCount;
    }

    /**
     *
     * @return
     */
    public int getStaffCount() {
        return staffCount;
    }

    /**
     *
     * @return
     */
    public int getStoreCount() {
        return storeCount;
    }

    /**
     *
     * @return
     */
    public List<Integer> getListCount() {
        return listCount;
    }

    /**
     *
     * @param listCount
     */
    public void setListCount(List<Integer> listCount) {
        this.listCount = listCount;
    }

}
