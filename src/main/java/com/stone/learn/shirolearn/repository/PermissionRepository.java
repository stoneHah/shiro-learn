package com.stone.learn.shirolearn.repository;

import com.stone.learn.shirolearn.entity.SysPermission;
import com.stone.learn.shirolearn.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<SysPermission,Long> {
}
