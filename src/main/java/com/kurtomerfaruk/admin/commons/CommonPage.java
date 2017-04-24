package com.kurtomerfaruk.admin.commons;

import com.kurtomerfaruk.admin.models.Staff;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Omer Faruk KURT
 * @email kurtomerfaruk@gmail.com
 * @blog http://kurtomerfaruk.wordpress.com
 */

public class CommonPage {

    private static Map<Staff, UserForm> users = new HashMap<Staff, UserForm>();
    private static List<Staff> staffList = new ArrayList<>();

    public static Map<Staff, UserForm> getUsers() {
        return users;
    }

    public static void setUsers(Map<Staff, UserForm> users) {
        CommonPage.users = users;
    }

    public static List<Staff> getStaffList() {
        return staffList;
    }
    
    

    public static void addStaff(UserForm userForm, String sessionId) {
        if (users.containsKey(userForm.getStaff())) {
            UserForm oldUserSession = (UserForm) users.get(userForm.getStaff());
            if (!oldUserSession.getSession().getId().equalsIgnoreCase(sessionId)) {
                try {
                    oldUserSession.getSession().invalidate();
                } catch (Exception localException) {
                }
                users.remove(userForm.getStaff());
                staffList.remove(userForm.getStaff());
                System.out.println("This user have another session,kill it");
            }
        }
        users.put(userForm.getStaff(), userForm);
        staffList.add(userForm.getStaff());
    }

    public static void removeStaff(Staff staff) {
        if (users.containsKey(staff)) {
            users.remove(staff);
            staffList.remove(staff);
        }
    }

    public static int getUserSessionSize() {
        return users.size();
    }

}
