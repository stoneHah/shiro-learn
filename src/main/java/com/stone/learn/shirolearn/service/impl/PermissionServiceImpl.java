package com.stone.learn.shirolearn.service.impl;

import com.stone.learn.shirolearn.entity.SysPermission;
import com.stone.learn.shirolearn.repository.PermissionRepository;
import com.stone.learn.shirolearn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public SysPermission createPermission(SysPermission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionRepository.delete(permissionId);
    }
}
