package com.stone.learn.shirolearn.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SysRolesPermissionsPK implements Serializable {
    private long roleId;
    private long permissionId;

    @Column(name = "role_id", nullable = false)
    @Id
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Column(name = "permission_id", nullable = false)
    @Id
    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRolesPermissionsPK that = (SysRolesPermissionsPK) o;

        if (roleId != that.roleId) return false;
        if (permissionId != that.permissionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (int) (permissionId ^ (permissionId >>> 32));
        return result;
    }
}
