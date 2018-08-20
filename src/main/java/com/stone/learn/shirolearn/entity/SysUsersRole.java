package com.stone.learn.shirolearn.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_users_roles", schema = "test", catalog = "")
@IdClass(SysUsersRolesPK.class)
public class SysUsersRole {
    private long userId;
    private long roleId;

    public SysUsersRole() {
    }

    public SysUsersRole(long userId, long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "role_id", nullable = false)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUsersRole that = (SysUsersRole) o;

        if (userId != that.userId) return false;
        if (roleId != that.roleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        return result;
    }
}
