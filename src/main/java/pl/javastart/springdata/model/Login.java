package pl.javastart.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginName;
    private boolean hasPermission;
    private boolean hasPermissionLoad;
    private boolean hasPermissionExport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public boolean isHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public boolean isHasPermissionLoad() {
        return hasPermissionLoad;
    }

    public void setHasPermissionLoad(boolean hasPermissionLoad) {
        this.hasPermissionLoad = hasPermissionLoad;
    }

    public boolean isHasPermissionExport() {
        return hasPermissionExport;
    }

    public void setHasPermissionExport(boolean hasPermissionExport) {
        this.hasPermissionExport = hasPermissionExport;
    }
}
