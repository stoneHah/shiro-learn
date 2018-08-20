package com.stone.learn.shirolearn.service.impl;

import com.stone.learn.shirolearn.entity.SysPermission;
import com.stone.learn.shirolearn.entity.SysRole;
import com.stone.learn.shirolearn.entity.SysUser;
import com.stone.learn.shirolearn.entity.SysUsersRole;
import com.stone.learn.shirolearn.repository.UserRepository;
import com.stone.learn.shirolearn.repository.UserRoleRepository;
import com.stone.learn.shirolearn.service.UserService;
import com.stone.learn.shirolearn.suppport.PasswordHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public SysUser createUser(SysUser user) {
        passwordHelper.encryptPassword(user);
        return userRepository.save(user);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        SysUser user = userRepository.findOne(userId);
        user.setPassword(newPassword);

        passwordHelper.encryptPassword(user);
        userRepository.save(user);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        if (ArrayUtils.isEmpty(roleIds)) {
            return;
        }

        List<SysUsersRole> userRoles = new ArrayList<>();
        for (Long roleId : roleIds) {
            SysUsersRole userRole = new SysUsersRole(userId,roleId);
            userRoles.add(userRole);
        }
        userRoleRepository.save(userRoles);
    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        if (ArrayUtils.isEmpty(roleIds)) {
            return;
        }

        List<SysUsersRole> userRoles = new ArrayList<>();
        for (Long roleId : roleIds) {
            SysUsersRole userRole = new SysUsersRole(userId,roleId);
            userRoles.add(userRole);
        }
        userRoleRepository.delete(userRoles);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        SysUser user = findByUsername(username);
        if (user == null) {
            return Collections.emptySet();
        }

        Set<String> roles = new HashSet<>();
        List<SysRole> roleList = user.getRoles();
        if (!CollectionUtils.isEmpty(roleList)) {
            for (SysRole sysRole : roleList) {
                roles.add(sysRole.getRole());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(String username) {
        SysUser user = findByUsername(username);
        if (user == null) {
            return Collections.emptySet();
        }

        Set<String> permissions = new HashSet<>();
        List<SysRole> roleList = user.getRoles();
        if (!CollectionUtils.isEmpty(roleList)) {
            for (SysRole sysRole : roleList) {
                List<SysPermission> rolePermissions = sysRole.getPermissions();
                if (CollectionUtils.isEmpty(rolePermissions)) {
                    for (SysPermission rolePermission : rolePermissions) {
                        permissions.add(rolePermission.getPermission());
                    }
                }
            }
        }
        return permissions;
    }
}
