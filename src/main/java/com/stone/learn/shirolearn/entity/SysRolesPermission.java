package com.stone.learn.shirolearn.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_roles_permissions", schema = "test", catalog = "")
@IdClass(SysRolesPermissionsPK.class)
public class SysRolesPermission {
    private long roleId;
    private long permissionId;

    public SysRolesPermission() {
    }

    public SysRolesPermission(long roleId, long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    @Id
    @Column(name = "role_id", nullable = false)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "permission_id", nullable = false)
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

        SysRolesPermission that = (SysRolesPermission) o;

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
