package com.kurtomerfaruk.admin.audit;

import com.kurtomerfaruk.admin.models.Staff;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.context.FacesContext;
import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.descriptors.DescriptorEventAdapter;
import org.eclipse.persistence.queries.InsertObjectQuery;
import org.eclipse.persistence.queries.WriteObjectQuery;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.changesets.ChangeRecord;
import org.eclipse.persistence.sessions.changesets.DirectToFieldChangeRecord;

/**
 *
 * @author Omer Faruk KURT
 * @Created on date 18/10/2016 15:31:36
 */
public class AuditListener extends DescriptorEventAdapter implements SessionCustomizer, DescriptorCustomizer {

    public static ThreadLocal currentUser = new ThreadLocal();
    private Staff staff;

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
        staff = (Staff) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("staff");
        processEvent(event, AuditOperation.INSERT);
    }

    @Override
    public void aboutToUpdate(DescriptorEvent event) {
        staff = (Staff) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("staff");
        processEvent(event, AuditOperation.UPDATE);
    }

    @Override
    public void aboutToDelete(DescriptorEvent event) {
        staff = (Staff) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("staff");
        processEvent(event, AuditOperation.DELETE);
    }

    public void processEvent(DescriptorEvent event, AuditOperation operation) {
        Date date = new Date();

        for (String table : (List<String>) event.getDescriptor().getTableNames()) {

            if (operation == AuditOperation.UPDATE) {
                processWriteEvent(event, operation, date, table);
            } else {
                processAuditEvent(event, operation, date, table);
            }
        }

    }

    protected void processAuditEvent(DescriptorEvent event, AuditOperation operation, Date date, String tableName) {
        AuditEntry entry = createAuditEntry(event, operation, date, tableName);
        InsertObjectQuery insertObjectQuery = new InsertObjectQuery(entry);
        event.getSession().executeQuery(insertObjectQuery);
    }

    protected void processWriteEvent(DescriptorEvent event,
            AuditOperation operation,
            Date date,
            String tableName) {
        AuditEntry entry = createAuditEntry(event, operation, date, tableName);

        Collection<AuditField> fields = new LinkedList<AuditField>();
        WriteObjectQuery query = (WriteObjectQuery) event.getQuery();
        List<ChangeRecord> changes = query.getObjectChangeSet().getChanges();

        for (ChangeRecord change : changes) {
            if (change instanceof DirectToFieldChangeRecord) {
                DirectToFieldChangeRecord fieldChange = (DirectToFieldChangeRecord) change;
                AuditField field = new AuditField();
                field.setAuditEntryId(entry);
                field.setFieldName(fieldChange.getAttribute());
                field.setFieldValue(fieldChange.getNewValue().toString());
                fields.add(field);
            }
        }

        entry.setField(fields);

        InsertObjectQuery insertQuery = new InsertObjectQuery(entry);
        event.getSession().executeQuery(insertQuery);

        for (AuditField field : fields) {
            insertQuery = new InsertObjectQuery(field);
            event.getSession().executeQuery(insertQuery);
        }
    }

    protected AuditEntry createAuditEntry(DescriptorEvent event,
            AuditOperation operation,
            Date date,
            String tableName) {
        AuditEntry entry = new AuditEntry();

        entry.setAuditUser(staff);
        entry.setOperation(operation);
        entry.setOperationTime(date);
        entry.setEventId(Long.valueOf(event.getSource().hashCode()));
        entry.setTableName(tableName);
        return entry;
    }

}
