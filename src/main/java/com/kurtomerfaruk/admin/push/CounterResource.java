package com.kurtomerfaruk.admin.push;

import com.kurtomerfaruk.admin.models.Staff;
import java.util.List;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

/**
 *
 * @author Omer Faruk KURT
 */
@PushEndpoint("/counter")
public class CounterResource {

    @OnMessage(encoders = {JSONEncoder.class})
    public List<Staff> onMessage(List<Staff> staffList) {
        return staffList;
    }
}
