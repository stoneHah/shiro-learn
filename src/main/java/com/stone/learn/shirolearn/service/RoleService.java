package com.stone.learn.shirolearn.service;

import com.stone.learn.shirolearn.entity.SysRole;

public interface RoleService {

    SysRole createRole(SysRole role);

    void deleteRole(Long roleId);

    void correlationPermissions(Long roleId, Long... permissionIds);

    void unCorrelationPermissions(Long roleId, Long... permissionIds);
}
