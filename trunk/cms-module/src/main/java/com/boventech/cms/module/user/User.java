package com.boventech.cms.module.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ForeignKey;

import com.boventech.cms.module.Image;
import com.boventech.cms.module.right.AuthrizableEntity;
import com.boventech.cms.module.right.Privilege;
import com.boventech.cms.module.right.Role;
import com.boventech.util.user.UserRight;

@Entity
@Table(name = "T_USER")
@ForeignKey(name = "CMS_USER")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends AbstractUser implements AuthrizableEntity {

    /**
	 * 
	 */
    private static final long serialVersionUID = 4662879873954118885L;

    private String email;

    private String phone;

    private String address;

    private String appendix;

    private boolean activated;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image portrait;

    @ManyToMany(fetch = FetchType.LAZY)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private List<Role> roles = new ArrayList<Role>();

    private boolean ldapValidate;

    public boolean hasRole(Role role) {
        return UserRight.SUPERADMIN.equals(this.right()) || this.roles.contains(role);
    }

    public boolean hasPrivilege(Privilege plg) {
        if (UserRight.SUPERADMIN.equals(this.getUserRight()))
            return true;
        else {
            for (Role role : this.roles) {
                if (role.hasPrivilege(plg))
                    return true;
            }
            return false;
        }
    }

    public void replaceRoles(List<Role> roles) {
        this.roles.clear();
        this.roles.addAll(roles);
    }

    public void removeRoles() {
        this.roles.clear();
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Image getPortrait() {
        return portrait;
    }

    public void setPortrait(Image portrait) {
        this.portrait = portrait;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isLdapValidate() {
        return ldapValidate;
    }

    public void setLdapValidate(boolean ldapValidate) {
        this.ldapValidate = ldapValidate;
    }

}
