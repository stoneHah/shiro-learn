package com.stone.learn.shirolearn.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_permissions", schema = "test", catalog = "")
public class SysPermission {
    private long id;
    private String permission;
    private String description;
    private Boolean available;

    public SysPermission() {
    }

    public SysPermission(String permission, String desc, Boolean avalible) {
        this.permission = permission;
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
    @Column(name = "permission", nullable = true, length = 100)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysPermission that = (SysPermission) o;

        if (id != that.id) return false;
        if (permission != null ? !permission.equals(that.permission) : that.permission != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (available != null ? !available.equals(that.available) : that.available != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (permission != null ? permission.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        return result;
    }
}
