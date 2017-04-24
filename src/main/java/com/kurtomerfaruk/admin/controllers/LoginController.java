package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.commons.CommonPage;
import com.kurtomerfaruk.admin.commons.UserForm;
import com.kurtomerfaruk.admin.dao.IStaffDAO;
import com.kurtomerfaruk.admin.dao.impl.StaffDAOImpl;
import com.kurtomerfaruk.admin.enums.ERole;
import com.kurtomerfaruk.admin.models.Staff;
import com.kurtomerfaruk.admin.models.UserRoles;
import com.kurtomerfaruk.admin.utils.JsfUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@ManagedBean
@SessionScoped
public class LoginController implements java.io.Serializable {

    private static final long serialVersionUID = 1553957937211717410L;

    private String username;
    private String password;

    private boolean loggedIn;

    private IStaffDAO dao;

    private Staff staff;

    private int sessionCount;

    
    private List<ERole> roles;
    
    private String ipAddress;

    /**
     *
     */
    public LoginController() {
    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        dao = new StaffDAOImpl();
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     *
     * @param staff
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     *
     * @return
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     *
     * @param loggedIn
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     *
     * @return
     */
    public int getSessionCount() {
        return CommonPage.getUserSessionSize();
    }

    public List<Staff> getStaffList() {
        return CommonPage.getStaffList();
    }

    public List<ERole> getRoles() {
        return roles;
    }

    public void setRoles(List<ERole> roles) {
        this.roles = roles;
    }
    
    

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    

    /**
     *
     */
    public void login() {
        try {
            if (!username.equals("") && !username.equals(null) && !password.equals("") && !password.equals(null)) {
                staff = dao.login(username, password);
            }

            if (staff != null) {
                UserForm form = new UserForm();
                loggedIn = true;

                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                
                roles = new ArrayList<>();
                
                for (int i = 0; i < staff.getRoleList().size(); i++) {
                    UserRoles get = staff.getRoleList().get(i);
                    roles.add(get.getRole());
                }

                ipAddress = request.getHeader("X-FORWARDED-FOR");
                if (ipAddress == null) {
                    ipAddress = request.getRemoteAddr();
                }

                form.setSessionId(request.getSession().getId());
                form.setSessionCreatedTime(new Date(session.getCreationTime()));
                form.setUserIpAdress(ipAddress);
                form.setSession(request.getSession());
                form.setStaff(staff);

                CommonPage.addStaff(form, request.getSession().getId());

                EventBus eventBus = EventBusFactory.getDefault().eventBus();
                eventBus.publish("/counter", String.valueOf(CommonPage.getStaffList().size()));

                session.setAttribute("staff", staff);
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } else {
                JsfUtil.addExclamationMessage(ResourceBundle.getBundle("/messages").getString("alertUsername"));
            }

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            CommonPage.removeStaff(staff);
            EventBus eventBus = EventBusFactory.getDefault().eventBus();
            eventBus.publish("/counter", String.valueOf(CommonPage.getStaffList().size()));
            loggedIn = false;
            staff = null;
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean hasRole(ERole role){
        return roles.contains(role);
    }

}
