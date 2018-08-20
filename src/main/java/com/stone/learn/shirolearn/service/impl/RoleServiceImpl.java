package com.stone.learn.shirolearn.service.impl;

import com.stone.learn.shirolearn.entity.SysRole;
import com.stone.learn.shirolearn.entity.SysRolesPermission;
import com.stone.learn.shirolearn.repository.RolePermissionRepository;
import com.stone.learn.shirolearn.repository.RoleRepository;
import com.stone.learn.shirolearn.service.RoleService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public SysRole createRole(SysRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.delete(roleId);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        if (ArrayUtils.isEmpty(permissionIds)) {
            return;
        }

        List<SysRolesPermission> rolesPermissions = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            rolesPermissions.add(new SysRolesPermission(roleId, permissionId));
        }

        rolePermissionRepository.save(rolesPermissions);
    }

    @Override
    public void unCorrelationPermissions(Long roleId, Long... permissionIds) {
        if (ArrayUtils.isEmpty(permissionIds)) {
            return;
        }

        List<SysRolesPermission> rolesPermissions = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            rolesPermissions.add(new SysRolesPermission(roleId, permissionId));
        }

        rolePermissionRepository.delete(rolesPermissions);
    }
}
