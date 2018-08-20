package com.stone.learn.shirolearn.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_roles", schema = "test", catalog = "")
public class SysRole {
    private long id;
    private String role;
    private String description;
    private Boolean available;

    private List<SysPermission> permissions;

    public SysRole() {
    }

    public SysRole(String role, String desc, Boolean avalible) {
        this.role = role;
        this.description = desc;
        this.available = avalible;
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 100)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "available", nullable = true)
    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @ManyToMany
    @JoinTable(name = "sys_roles_permissions",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRole sysRoles = (SysRole) o;

        if (id != sysRoles.id) return false;
        if (role != null ? !role.equals(sysRoles.role) : sysRoles.role != null) return false;
        if (description != null ? !description.equals(sysRoles.description) : sysRoles.description != null)
            return false;
        if (available != null ? !available.equals(sysRoles.available) : sysRoles.available != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        return result;
    }
}
