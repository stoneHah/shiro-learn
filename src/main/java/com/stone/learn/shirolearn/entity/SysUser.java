package com.stone.learn.shirolearn.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_users", schema = "test", catalog = "")
public class SysUser {
    private long id;
    private String username;
    private String password;
    private String salt;
    private Boolean locked;


    private List<SysRole> roles;

    public SysUser() {
    }

    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
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
    @Column(name = "username", nullable = true, length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt", nullable = true, length = 100)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "locked", nullable = true)
    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @ManyToMany
    @JoinTable(name = "sys_users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUser sysUsers = (SysUser) o;

        if (id != sysUsers.id) return false;
        if (username != null ? !username.equals(sysUsers.username) : sysUsers.username != null) return false;
        if (password != null ? !password.equals(sysUsers.password) : sysUsers.password != null) return false;
        if (salt != null ? !salt.equals(sysUsers.salt) : sysUsers.salt != null) return false;
        if (locked != null ? !locked.equals(sysUsers.locked) : sysUsers.locked != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (locked != null ? locked.hashCode() : 0);
        return result;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }
}
