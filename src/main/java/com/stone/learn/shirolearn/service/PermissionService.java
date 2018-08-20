package com.stone.learn.shirolearn.service;

import com.stone.learn.shirolearn.entity.SysPermission;

public interface PermissionService {
    SysPermission createPermission(SysPermission permission);

    void deletePermission(Long permissionId);
}
