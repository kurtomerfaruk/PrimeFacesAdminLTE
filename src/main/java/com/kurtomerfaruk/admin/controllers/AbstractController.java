package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.dao.IColumnSettings;
import com.kurtomerfaruk.admin.dao.IGenericDAO;
import com.kurtomerfaruk.admin.dao.impl.ColumnSettingsDAOImpl;
import com.kurtomerfaruk.admin.dao.impl.GenericDAOImpl;
import com.kurtomerfaruk.admin.functions.Functions;
import com.kurtomerfaruk.admin.models.ColumnModel;
import com.kurtomerfaruk.admin.models.ColumnSettings;
import com.kurtomerfaruk.admin.utils.JsfUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.ColumnResizeEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.Visibility;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 * @param <T>
 */
public class AbstractController<T> {

    /**
     *
     */
    protected IGenericDAO<T> dao;

    /**
     *
     */
    protected IColumnSettings columnsDAO = new ColumnSettingsDAOImpl();

    private T selected;
    private List<T> filtered;
    private Class<T> itemClass;
    private Collection<T> items;
    private LazyDataModel<T> lazyList;
    private Object paramItems;
    private List<String> columnNameList;
    private List<ColumnModel> columns;
    private List<String> manyToOneList;
    private List<String> searchColumnNameList;

    private List<Boolean> listVisible;
    private List<Integer> listWidth;

    private List<ColumnSettings> columnsList;

    private enum PersistAction {

        CREATE,
        DELETE,
        UPDATE
    }

    /**
     *
     * @param itemClass
     */
    public AbstractController(Class<T> itemClass) {
        //super(itemClass);
        dao = new GenericDAOImpl<T>(itemClass);
        this.itemClass = itemClass;
        listVisible = new ArrayList<Boolean>();
        listWidth = new ArrayList<>();
        //columnList();
    }

    /**
     *
     * @return
     */
    public T getSelected() {
        return selected;
    }

    /**
     *
     * @param selected
     */
    public void setSelected(T selected) {
        this.selected = selected;
    }

    /**
     *
     * @return
     */
    public List<T> getFiltered() {
        return filtered;
    }

    /**
     *
     * @param filtered
     */
    public void setFiltered(List<T> filtered) {
        this.filtered = filtered;
    }

    /**
     *
     * @return
     */
    public Class<T> getItemClass() {
        return itemClass;
    }

    /**
     *
     * @param itemClass
     */
    public void setItemClass(Class<T> itemClass) {
        this.itemClass = itemClass;
    }

    /**
     *
     * @return
     */
    public Collection<T> getItems() {
        if (items == null) {
            //items = findAll();
            items = dao.findAll();
        }
        return items;
    }

    /**
     *
     * @param items
     */
    public void setItems(Collection<T> items) {
        this.items = items;
    }

    /**
     *
     * @return
     */
    public LazyDataModel<T> getLazyList() {
        if (lazyList == null) {
            lazyList = new LazyDataModel<T>() {
                private static final long serialVersionUID = 5340099026592784595L;
                List<T> result;

                @Override
                public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    if (getParamItems() != null) {
                        result = (List<T>) paramItems;
                        lazyList.setRowCount(result.size());
                    } else {
                        result = dao.loadLazy(first, pageSize, sortField, sortOrder, filters,searchColumnNameList);
                        lazyList.setRowCount(dao.count(filters,searchColumnNameList));
                    }
                    return result;
                }

                @Override
                public T getRowData(String rowKey) {
                    if (pkFieldType().contains("Short")) {
                        return rowKey.equals("null") ? null : (T) dao.read(Short.parseShort(rowKey));
                    } else if (pkFieldType().contains("Integer")) {
                        return rowKey.equals("null") ? null : (T) dao.read(Integer.parseInt(rowKey));
                    } else if (pkFieldType().contains("Long")) {
                        return rowKey.equals("null") ? null : (T) dao.read(Long.parseLong(rowKey));
                    } else {
                        return null;
                    }
                }
            };
        }
        return lazyList;
    }

    /**
     *
     * @param lazyList
     */
    public void setLazyList(LazyDataModel<T> lazyList) {
        this.lazyList = lazyList;
    }

    /**
     *
     * @return
     */
    public Object getParamItems() {
        return paramItems;
    }

    /**
     *
     * @param paramItems
     */
    public void setParamItems(Object paramItems) {
        this.paramItems = paramItems;
    }

    /**
     *
     * @return
     */
    public List<String> getColumnNameList() {
        return columnNameList;
    }

    /**
     *
     * @param columnNameList
     */
    public void setColumnNameList(List<String> columnNameList) {
        this.columnNameList = columnNameList;
    }

    /**
     *
     * @return
     */
    public List<ColumnModel> getColumns() {
        return columns;
    }

    /**
     *
     * @param columns
     */
    public void setColumns(List<ColumnModel> columns) {
        this.columns = columns;
    }

    /**
     *
     * @return
     */
    public List<String> getManyToOneList() {
        return manyToOneList;
    }

    /**
     *
     * @param manyToOneList
     */
    public void setManyToOneList(List<String> manyToOneList) {
        this.manyToOneList = manyToOneList;
    }

    /**
     *
     * @return
     */
    public List<String> getSearchColumnNameList() {
        return searchColumnNameList;
    }

    /**
     *
     * @param searchColumnNameList
     */
    public void setSearchColumnNameList(List<String> searchColumnNameList) {
        this.searchColumnNameList = searchColumnNameList;
    }
    
    /**
     *
     * @return
     */
    public List<Boolean> getListVisible() {
        return listVisible;
    }

    /**
     *
     * @param listVisible
     */
    public void setListVisible(List<Boolean> listVisible) {
        this.listVisible = listVisible;
    }

    /**
     *
     * @return
     */
    public List<Integer> getListWidth() {
        return listWidth;
    }

    /**
     *
     * @param listWidth
     */
    public void setListWidth(List<Integer> listWidth) {
        this.listWidth = listWidth;
    }

    /**
     *
     * @return
     */
    public List<ColumnSettings> getColumnsList() {
        return columnsList;
    }

    /**
     *
     * @param columnsList
     */
    public void setColumnsList(List<ColumnSettings> columnsList) {
        this.columnsList = columnsList;
    }

    private String pkFieldType() {

        for (Field field : itemClass.getDeclaredFields()) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.toString().contains("javax.persistence.Id")) {
                    return field.getType().toString();
                }
            }
        }
        return null;
    }

    /**
     *
     * @param event
     * @return
     */
    public T prepareCreate(ActionEvent event) {
        T newItem;
        try {
            newItem = itemClass.newInstance();
            this.selected = newItem;
            initializeEmbeddableKey();
            return newItem;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     */
    protected void initializeEmbeddableKey() {
        // Nothing to do if entity does not have any embeddable key.
    }

    /**
     *
     * @param event
     */
    public void save(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/messages").getString(itemClass.getSimpleName() + "Updated");
        persist(PersistAction.UPDATE, msg);
        if (!isValidationFailed()) {
            selected = null;
        }
    }

    /**
     *
     * @param event
     */
    public void saveNew(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/messages").getString(itemClass.getSimpleName() + "Created");
        persist(PersistAction.CREATE, msg);
        if (!isValidationFailed()) {
            selected = null;
        }
    }

    /**
     *
     * @param event
     */
    public void delete(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/messages").getString(itemClass.getSimpleName() + "Deleted");
        persist(PersistAction.DELETE, msg);
        if (!isValidationFailed()) {
            selected = null; // Remove selection
        }
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            try {
                dao.beginTransaction();
                if (persistAction == PersistAction.CREATE) {
                    dao.create(selected);
                } else if (persistAction == PersistAction.UPDATE) {
                    dao.update(selected);
                } else if (persistAction == PersistAction.DELETE) {
                    dao.delete(selected);
                }
                dao.commit();
                JsfUtil.addSuccessMessage(successMessage);
            } catch (Exception ex) {
                dao.rollback();
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/messages").getString("PersistenceErrorOccured"));
            }
        }
    }

    /**
     *
     * @return
     */
    public boolean isValidationFailed() {
        return JsfUtil.isValidationFailed();
    }

    /**
     * Retrieve a collection of Entity items for a specific Controller from
     * another JSF page via Request parameters.
     */
    @PostConstruct
    public void initParams() {
        paramItems = FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(itemClass.getSimpleName() + "_items");
        if (paramItems != null) {
            setItems((Collection<T>) paramItems);
            //setLazyList((LazyDataModel<T>) paramItems);
        }
    }

    /**
     *
     */
    public void columnNames() {
        columnNameList = new ArrayList<>();
        searchColumnNameList= new ArrayList<>();
        manyToOneList = new ArrayList<>();

        for (Field field : this.getItemClass().getDeclaredFields()) {
            if (!field.getType().toString().contains("java.util.List")) {
                if (!field.getName().equals("serialVersionUID")) {
                    if (field.getType().toString().contains("com.kurtomerfaruk.admin.models")) {
                        manyToOneList.add(field.getName());
                    } else {
                        columnNameList.add(field.getName());
                        searchColumnNameList.add(field.getName());
                    }
                }
            }
        }
        for (Field field : this.getItemClass().getSuperclass().getDeclaredFields()) {
            if (!field.getType().toString().contains("java.util.List")) {
                if (!field.getName().equals("serialVersionUID")) {
                    if (field.getType().toString().contains("com.kurtomerfaruk.admin.models")) {
                        manyToOneList.add(field.getName());
                    } else {
                        columnNameList.add(field.getName());
                        searchColumnNameList.add(field.getName());
                    }
                }
            }
        }
    }

//    public void createColumns() {
//        columns = new ArrayList<>();
//        for (String columnKey : columnNameList) {
//            String key = columnKey.trim();
//            if (key.contains("date")) {
//                columns.add(new ColumnModel(key, key, Boolean.TRUE, Boolean.FALSE));
//            } else {
//                columns.add(new ColumnModel(key, key, Boolean.FALSE, Boolean.FALSE));
//            }
//        }
//
//        //columns.add(new ColumnModel("Header", "cityId", Boolean.FALSE, Boolean.TRUE));
////        for (String columnKey : manyToOneList) {
////            String key = columnKey.trim();
////            if (key.equals("cityId")) {
////                columns.add(new ColumnModel(key, key, Boolean.TRUE, Boolean.TRUE, "city"));
////            }
////        }
//    }

    /**
     * Sets any embeddable key fields if an Entity uses composite keys. If the
     * entity does not have composite keys, this method performs no actions and
     * exists purely to be overridden inside a concrete controller class.
     */
    protected void setEmbeddableKeys() {
        // Nothing to do if entity does not have any embeddable key.
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {

    }

    /**
     *
     * @param e
     */
    public void onToggle(org.primefaces.event.ToggleEvent e) {
        listVisible.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
    }

    /**
     *
     * @param event
     */
    public void onResize(ColumnResizeEvent event) {
        String[] str = event.getColumn().getColumnKey().split(":");
        int colIndex = str.length;
        listWidth.set(Integer.parseInt(str[colIndex - 1]), event.getWidth());
    }

    /**
     *
     */
    public void columnList() {
        columnsList = columnsDAO.findByTableName(this.getItemClass().getSimpleName());

        if (columnsList == null || columnsList.isEmpty()) {
            try {
                columnsDAO.beginTransaction();
                for (int i = 0; i < columnNameList.size(); i++) {
                    ColumnSettings columnSetting = new ColumnSettings();
                    

                    columnSetting.setTableName(this.getItemClass().getSimpleName());
                    columnSetting.setColumnQueue((short) i);
                    columnSetting.setVisible(true);
                    columnSetting.setColumnName(columnNameList.get(i));
                    columnSetting.setWidth(400);
                    columnsDAO.create(columnSetting);
                    
                    columnsList.add(columnSetting);
                }
                columnsDAO.commit();
            } catch (Exception e) {
                columnsDAO.rollback();
            }
        } 
            columns = new ArrayList<>();
            for (ColumnSettings get : columnsList) {
                listVisible.add(get.getVisible());
                listWidth.add(get.getWidth());
                Boolean isDate=Boolean.FALSE;
                if(get.getColumnName().contains("date")){
                    isDate=Boolean.TRUE;
                }else{
                    isDate=Boolean.FALSE;
                }
                if(!get.getVisible()){
                    searchColumnNameList.remove(get.getColumnName());
                }
                columns.add(new ColumnModel(Functions.firstUpperCase(get.getColumnName()), get.getColumnName(), isDate, false));
            
        }

    }

    /**
     *
     */
    public void columnSave() {

        if (columnsList != null && !columnsList.isEmpty()) {
            try {
                columnsDAO.beginTransaction();
                for (int i = 0; i < columnsList.size(); i++) {
                    ColumnSettings settings = columnsList.get(i);
                    settings.setWidth(listWidth.get(i));
                    settings.setVisible(listVisible.get(i));
                    if(settings.getVisible()){
                        searchColumnNameList.add(settings.getColumnName());
                    }
                    columnsDAO.update(settings);
                }
                columnsDAO.commit();
                
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/messages").getString("themeSaved"));
            } catch (Exception e) {
                columnsDAO.rollback();
            }
        }

    }

}
