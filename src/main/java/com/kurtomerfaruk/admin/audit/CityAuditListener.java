package com.kurtomerfaruk.admin.audit;

import com.kurtomerfaruk.admin.models.City;
import java.util.Date;
import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.descriptors.DescriptorEventAdapter;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author Omer Faruk KURT
 * @Created on date 19/10/2016 09:50:20
 */
public class CityAuditListener extends DescriptorEventAdapter implements SessionCustomizer, DescriptorCustomizer {

    @Override
    public void customize(Session sn) throws Exception {
        for (ClassDescriptor cd : sn.getDescriptors().values()) {
            customize(cd);
        }
    }

    @Override
    public void customize(ClassDescriptor cd) throws Exception {
        cd.getEventManager().addListener(this);
    }

    @Override
    public void aboutToInsert(DescriptorEvent event) {
        processEvent(event, AuditOperation.INSERT);
    }

    private void processEvent(DescriptorEvent event, AuditOperation operation) {
//        City city = (City) event.getSource();
//        if(city!=null){
//            System.out.println("city:"+city.getCity());
//        }
//        System.out.println("get:"+event.getSource().toString());
        if (operation == AuditOperation.INSERT) {
            insert(event, operation);
        }
    }

    private void insert(DescriptorEvent event, AuditOperation operation) {
        City city = (City) event.getSource();
        String table = "city_log.";
        //event.getRecord().put(table+"city_id", city.getCityId());
        event.getRecord().put(table + "operation", operation);
        event.getRecord().put(table + "last_update", city.getLastUpdate());
        event.getRecord().put(table + "operation_time", new Date());

        event.getSession().insertObject(event.getRecord());
    }

}
